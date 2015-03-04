package com.example.equation2ndgrade.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.equation2ndgrade.MainActivity;

public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {

	MainActivity myActivity = null;

	EditText editCoeffA;
	EditText editCoeffB;
	EditText editCoeffC;
	Button btnCalculate;
	
	MainActivityObject mainActivityObject;
	
	public MainActivityUnitTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		Intent intent = new Intent(getInstrumentation().getContext(), MainActivity.class);
		
		startActivity(intent, null, null);
		
		myActivity = getActivity();
		
		assertNotNull(myActivity);
		editCoeffA = (EditText) myActivity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffA);
		assertNotNull(editCoeffA);
		editCoeffB = (EditText) myActivity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffB);
		editCoeffC = (EditText) myActivity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffC);
		btnCalculate = (Button) myActivity
				.findViewById(com.example.equation2ndgrade.R.id.btn_calculate);
		
	
		mainActivityObject = new MainActivityObject(myActivity);
		
	}

	public void testSingleRootEquation() throws Throwable {

		runTestOnUiThread(new Runnable() {

			@Override
			public void run() {
				editCoeffA.setText("1");
				editCoeffB.setText("2");
				editCoeffC.setText("1");
				btnCalculate.performClick();
				
			}
		});
		
		TextView solution1View = (TextView) myActivity
				.findViewById(com.example.equation2ndgrade.R.id.textRoot1);
		
		assertEquals(mainActivityObject.formatRoot1Label(-1.0), solution1View.getText().toString());

	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
