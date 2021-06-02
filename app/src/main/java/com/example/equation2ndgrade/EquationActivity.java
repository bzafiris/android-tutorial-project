package com.example.equation2ndgrade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EquationActivity extends AppCompatActivity {

    EditText editCoeffA;
    EditText editCoeffB;
    EditText editCoeffC;
    TextView txtDiscriminant;
    TextView txtStatus;
    TextView txtSolution1;
    TextView txtSolution2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);

        editCoeffA = (EditText) findViewById(R.id.editCoeffA);
        editCoeffB = (EditText) findViewById(R.id.editCoeffB);
        editCoeffC = (EditText) findViewById(R.id.editCoeffC);

        txtDiscriminant = (TextView) findViewById(R.id.textDiscriminant);
        txtStatus = (TextView) findViewById(R.id.textStatus);
        txtSolution1 = (TextView) findViewById(R.id.textRoot1);
        txtSolution2 = (TextView) findViewById(R.id.textRoot2);

        Button btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        String status = getString(R.string.label_status);

        txtStatus.setText(String.format(status, "-"));
    }

    public void calculate(){

        String coeffA = editCoeffA.getText().toString();
        String coeffB = editCoeffB.getText().toString();
        String coeffC = editCoeffC.getText().toString();

        int a = Integer.parseInt(coeffA);
        int b = Integer.parseInt(coeffB);
        int c = Integer.parseInt(coeffC);

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double d = equation.getDiscriminant();
        double [] solution = equation.solution();

        txtDiscriminant.setText(getString(R.string.label_diakrinousa) + " " + Double.toString(d));

        String status = getString(R.string.label_status);

        if (d > 0){
            txtStatus.setText(String.format(status, getString(R.string.status_two_roots)));
        } else if (d == 0){
            txtStatus.setText(String.format(status, getString(R.string.status_double_root)));
        } else {
            txtStatus.setText(String.format(status, getString(R.string.status_no_root)));
            return;
        }

        txtSolution1.setText(getString(R.string.label_root1) + " " + Double.toString(solution[0]));
        if (solution.length == 2){
            txtSolution2.setText(getString(R.string.label_root2) + " " + Double.toString(solution[1]));
        }

    }

}