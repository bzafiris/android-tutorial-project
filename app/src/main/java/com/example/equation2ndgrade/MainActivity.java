package com.example.equation2ndgrade;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        editCoeffA = (EditText) findViewById(R.id.editCoeffA);
        editCoeffB = (EditText) findViewById(R.id.editCoeffB);
        editCoeffC = (EditText) findViewById(R.id.editCoeffC);

        txtDiscriminant = (TextView) findViewById(R.id.textDiscriminant);
        txtStatus = (TextView) findViewById(R.id.textStatus);
        txtSolution1 = (TextView) findViewById(R.id.textRoot1);
        txtSolution2 = (TextView) findViewById(R.id.textRoot2);

        String status = getString(R.string.label_status);

        txtStatus.setText(String.format(status, "-"));
    }

    public void onClickCalculate(View v){

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
