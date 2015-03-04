package com.example.equation2ndgrade;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Tests the MainActivity class with the Robolectric framework
 * 
 * @author Vassilis Zafeiris
 *
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "../app/AndroidManifest.xml")
public class MainActivityTest {

	private MainActivity activity;
	MainActivityObject mainActivityObject;
	EditText editCoeffA;
	EditText editCoeffB;
	EditText editCoeffC;
	Button btnCalculate;

	public MainActivityTest() {
	}

	@Before
	public void setUp() throws Exception {

		activity = Robolectric.buildActivity(MainActivity.class).create().get();
		editCoeffA = (EditText) activity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffA);

		editCoeffB = (EditText) activity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffB);
		editCoeffC = (EditText) activity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffC);
		btnCalculate = (Button) activity
				.findViewById(com.example.equation2ndgrade.R.id.btn_calculate);

		mainActivityObject = new MainActivityObject(activity);
	}

	@Test
	public void testSingleRootEquation() throws Throwable {

		editCoeffA.setText("1");
		editCoeffB.setText("2");
		editCoeffC.setText("1");
		btnCalculate.performClick();

		TextView solution1View = (TextView) activity
				.findViewById(com.example.equation2ndgrade.R.id.textRoot1);
		Assert.assertEquals(mainActivityObject.formatRoot1Label(-1.0),
				solution1View.getText().toString());

	}

	@Test
	public void testDoubleRootEquation() throws Throwable {

		editCoeffA.setText("1");
		editCoeffB.setText("-3");
		editCoeffC.setText("2");

		btnCalculate.performClick();

		TextView solution1View = (TextView) activity
				.findViewById(com.example.equation2ndgrade.R.id.textRoot1);

		Assert.assertEquals(mainActivityObject.formatRoot1Label(2.0),
				solution1View.getText().toString());

		TextView solution2View = (TextView) activity
				.findViewById(com.example.equation2ndgrade.R.id.textRoot2);
		Assert.assertEquals(mainActivityObject.formatRoot2Label(1.0),
				solution2View.getText().toString());

	}

	@After
	public void tearDown() throws Exception {
		activity.finish();

	}

}
