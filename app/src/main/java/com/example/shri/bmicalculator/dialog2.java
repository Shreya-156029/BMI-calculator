package com.example.shri.bmicalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class dialog2 extends AppCompatDialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Information")
                .setMessage("Your BMI(Body Mass Index)is based on your height and weight. It's one way to see if you're at a healthy weight.\n" +
                        "\n" +
                        "Underweight: Your BMI is less than 18.5\n" +
                        "\n" +
                        "Healthy weight: Your BMI is 18.5 to 24.9\n" +
                        "\n" +
                        "Overweight: Your BMI is 25 to 29.9\n" +
                        "\n" +
                        "Obese: Your BMI is 30 or higher")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();

    }
}
