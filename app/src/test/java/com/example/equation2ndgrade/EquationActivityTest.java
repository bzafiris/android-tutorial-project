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
 * Do not forget the project.properties file in app/src/main
 * @author Vassilis Zafeiris
 *
 */
@RunWith(RobolectricTestRunner.class)
@Config(
	sdk = 27, packageName = "com.example.equation2ndgrade"
)
public class EquationActivityTest {

	private EquationActivity activity;
	EquationActivityObject mainActivityObject;
	EditText editCoeffA;
	EditText editCoeffB;
	EditText editCoeffC;
	Button btnCalculate;

	public EquationActivityTest() {
	}

	@Before
	public void setUp() throws Exception {

		activity = Robolectric.buildActivity(EquationActivity.class).create().get();
		editCoeffA = (EditText) activity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffA);

		editCoeffB = (EditText) activity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffB);
		editCoeffC = (EditText) activity
				.findViewById(com.example.equation2ndgrade.R.id.editCoeffC);
		btnCalculate = (Button) activity
				.findViewById(com.example.equation2ndgrade.R.id.btn_calculate);

		mainActivityObject = new EquationActivityObject(activity);
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

		Assert.assertEquals(solution1View.getText().toString(), mainActivityObject.formatRoot1Label(2.0));

		TextView solution2View = (TextView) activity
				.findViewById(com.example.equation2ndgrade.R.id.textRoot2);
		Assert.assertEquals(solution2View.getText().toString(), mainActivityObject.formatRoot2Label(1.0));

	}



	@After
	public void tearDown() throws Exception {
		activity.finish();

	}

}
