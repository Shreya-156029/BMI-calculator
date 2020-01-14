package com.example.shri.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText height;
    private EditText weight;
    private TextView result;
    public TextView ideal;
    float norm;
    float idealweight_men;
    float heightValue;
    float weightValue;
    float idealweight_women;
   // Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        ideal=(TextView)findViewById(R.id.ideal_wt);
       // Spinner spinner=(Spinner)findViewById(R.id.spinner);
        //ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // spinner.setAdapter(adapter);
      //  spinner.setOnItemSelectedListener(this);
    }

    public void calculateBMI(View v) {

        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();


        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
           float height=Float.parseFloat(heightStr);
             heightValue = Float.parseFloat(heightStr) / 100;
             weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            norm=height-100;
            idealweight_men=norm-(norm*10/100);
            idealweight_women=norm-(norm*15/100);


            displayBMI(bmi);

          //  ideal.setText("Your ideal weight is "+idealweight_men);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";



        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);



        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText("Your BMI is: "+bmiLabel);
       // ideal.setText("Your ideal weight="+idealweight_women);

    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.aboutus: opendialog();
                               return true;
            case R.id.help:opendialog2();
                            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void opendialog()
    {
        dialog d=new dialog();
        d.show(getSupportFragmentManager(),"Example dialog");


    }
    public  void opendialog2()
    {
       dialog2 d2=new dialog2();
       d2.show(getSupportFragmentManager(),"Example dialog");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text=parent.getItemAtPosition(position).toString();

            ideal.setText("Your ideal weight=" + idealweight_men);






        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}