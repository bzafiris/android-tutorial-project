package com.example.equation2ndgrade;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Test class based on ActivityInstrumentationTestCase2.
 * It is based exclusively on the Android Testing API. 
 * @author Vassilis Zafeiris
 *
 */
public class MainActivityFunctionalTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	// Do not name the following variable as "activity", it hides a superclass
	// member variable
	MainActivity myActivity = null;

	MainActivityObject mainActivityObject;
	
	EditText editCoeffA;
	EditText editCoeffB;
	EditText editCoeffC;
	Button btnCalculate;

	public MainActivityFunctionalTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// Call the following before getActivity() in order to be able to
		// control the emulator or the device with key events send
		// from the tests
		setActivityInitialTouchMode(false);
		
		assertNull(myActivity);
		myActivity = getActivity();
		assertNotNull(myActivity);
		editCoeffA = (EditText) myActivity
				.findViewById(R.id.editCoeffA);
		assertNotNull(editCoeffA);
		editCoeffB = (EditText) myActivity
				.findViewById(R.id.editCoeffB);
		editCoeffC = (EditText) myActivity
				.findViewById(R.id.editCoeffC);
		btnCalculate = (Button) myActivity
				.findViewById(R.id.btn_calculate);
		
		mainActivityObject = new MainActivityObject(myActivity);
	}

    public void testNoSolutionEquation() throws Throwable {

        // Perform actions that alter activity state in the Ui thread
        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                editCoeffA.setText("3");
                editCoeffB.setText("-1");
                editCoeffC.setText("1");
                btnCalculate.performClick();
            }
        });

        TextView solution1View = (TextView) myActivity
                .findViewById(R.id.textRoot1);

        TextView solution2View = (TextView) myActivity
                .findViewById(R.id.textRoot2);

        assertEquals(mainActivityObject.formatRoot1Label(Double.NaN), solution1View.getText().toString());
        assertEquals(mainActivityObject.formatRoot2Label(Double.NaN), solution2View.getText().toString());

    }

	public void testSingleRootEquation() throws Throwable {

		// Perform actions that alter activity state in the Ui thread
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
				.findViewById(R.id.textRoot1);
		
		assertEquals(mainActivityObject.formatRoot1Label(-1.0), solution1View.getText().toString());

	}

	public void testDoubleRootEquation() throws Throwable {

		// alternative ways to run code in the ui thread
		myActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				editCoeffA.setText("1");
			}
		});

		runTestOnUiThread(new Runnable() {

			@Override
			public void run() {

				editCoeffB.setText("-3");
				editCoeffC.setText("2");
				btnCalculate.performClick();

			}
		});

		TextView solution1View = (TextView) myActivity
				.findViewById(R.id.textRoot1);
		assertEquals(mainActivityObject.formatRoot1Label(2.0), solution1View.getText().toString());
		
		TextView solution2View = (TextView) myActivity
				.findViewById(R.id.textRoot2);
		assertEquals(mainActivityObject.formatRoot2Label(1.0), solution2View.getText().toString());
	}



	@Override
	protected void tearDown() throws Exception {
		// closes the activity
		myActivity.finish();
		super.tearDown();

	}

}
