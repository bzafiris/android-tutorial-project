package com.example.equation2ndgrade.test;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.equation2ndgrade.MainActivity;
import com.robotium.solo.Solo;

/**
 * ActivityInstrumentationTestCase2 that uses the Robotium API to interact with
 * activity components.
 * 
 * @author Vassilis Zafeiris
 *
 */
public class MainActivityRobotiumTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	// Basic Robotium class for controlling activities
	Solo solo;
	MainActivityObject mainActivityObject;
	Context ctx;

	public MainActivityRobotiumTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// getActivity() -> Activity is created (onCreate is called)
		// getInstrumentation() -> Handle to the instrumentation context
		solo = new Solo(getInstrumentation(), getActivity());
		ctx = getInstrumentation().getContext();
		mainActivityObject = new MainActivityObject(getActivity());
	}

	public void testSingleRootEquation() {

		solo.clearEditText(0);
		solo.enterText(0, "1");

		solo.clearEditText(1);
		solo.enterText(1, "2");

		solo.clearEditText(2);
		solo.enterText(2, "1");

		// Click the first button that finds on the ui
		solo.clickOnButton(0);

		// Wait for the main thread to consume all events		
		getInstrumentation().waitForIdleSync();
		
		TextView solution1View = (TextView) getActivity()
				.findViewById(com.example.equation2ndgrade.R.id.textRoot1);
		
		
		assertEquals(mainActivityObject.formatRoot1Label(-1.0), solution1View.getText().toString());
		

	}

	public void testDoubleRootEquation() throws Throwable {

		solo.clearEditText(0);
		solo.enterText(0, "1");

		solo.clearEditText(1);
		solo.enterText(1, "-3");

		solo.clearEditText(2);
		solo.enterText(2, "2");

		solo.clickOnButton(0);

		getInstrumentation().waitForIdleSync();
		
		TextView solution1View = (TextView) getActivity()
				.findViewById(com.example.equation2ndgrade.R.id.textRoot1);
		
		assertEquals(mainActivityObject.formatRoot1Label(2.0), solution1View.getText().toString());
		
		TextView solution2View = (TextView) getActivity()
				.findViewById(com.example.equation2ndgrade.R.id.textRoot2);
		assertEquals(mainActivityObject.formatRoot2Label(1.0), solution2View.getText().toString());
		
	}

	@Override
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

}
