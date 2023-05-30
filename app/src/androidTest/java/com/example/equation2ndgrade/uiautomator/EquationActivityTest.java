package com.example.equation2ndgrade.uiautomator;

//Import the uiautomator libraries

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test case that uses the uiautomator framework.
 * 
 * @author Vassilis Zafeiris
 *
 */
@RunWith(AndroidJUnit4.class)
public class EquationActivityTest {

	public static String APP_NAME = "EquationSolvingApp";
	public static String APP_PACKAGE = "com.example.equation2ndgrade";

    private UiDevice mDevice;

	/**
	 * The main activity of the application. It is initialized in the setup
	 * method
	 */
	UiObject equationsAppMainActivity;

	@Before
	public void setUp() throws Exception {

		navigateToApp();
	}

	private void navigateToApp() throws UiObjectNotFoundException {
		// Simulate a short press on the HOME button.
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

		mDevice.pressHome();

		// Bring up the All Apps screen (requires English locale)
		UiObject allAppsButton = null;

		allAppsButton = mDevice.findObject(new UiSelector().text("Apps"));

        // In some devices "Apps" is part of contentDescription
		if (!allAppsButton.exists()){
			allAppsButton = mDevice.findObject(new UiSelector().descriptionContains("Apps"));
		}

		// Simulate a click to bring up the All Apps screen.
		allAppsButton.clickAndWaitForNewWindow();

//		UiObject appsTab = mDevice.findObject(new UiSelector().text("Apps"));
//		// Simulate a click to enter the Apps tab.
//		appsTab.click();

		// Simulate a user swiping until finding the application
//		UiScrollable appViews = new UiScrollable(
//				new UiSelector().scrollable(true));

		// Create a UiSelector to find the Equation2ndGrade app and simulate
		// a user click to launch the app.
		UiObject equationsApp = mDevice.findObject(new UiSelector()
                .className(android.widget.TextView.class.getName()).text(APP_NAME));

		equationsApp.clickAndWaitForNewWindow();

		// Validate that the package name is the expected one
		equationsAppMainActivity = mDevice.findObject(
				new UiSelector().packageName(APP_PACKAGE));

        Assert.assertTrue("Unable to detect EquationSolvingApp",
                equationsAppMainActivity.exists());
	}

    @Test
    public void testNoSolutionEquation() throws Throwable {

        EquationActivityObject mainActivity = new EquationActivityObject(mDevice);
        mainActivity.setCoefficientA("3");
        mainActivity.setCoefficientB("-1");
        mainActivity.setCoefficientC("1");

        mainActivity.closeSoftKeyboard();
        mainActivity.clickCalculateButton();

		mainActivity.swipeUp();

        String solutionLabel = mainActivity.getSolution1Text();
        Assert.assertEquals("Root 1:", solutionLabel);

        String solution2Label = mainActivity.getSolution2Text();
        Assert.assertEquals("Root 2:", solution2Label);

    }

    @Test
	public void testDoubleRootEquation() throws Throwable {

		EquationActivityObject mainActivity = new EquationActivityObject(mDevice);
		mainActivity.setCoefficientA("1");
		mainActivity.setCoefficientB("-3");
		mainActivity.setCoefficientC("2");

		mainActivity.closeSoftKeyboard();

		mainActivity.clickCalculateButton();

		mainActivity.swipeUp();

		String discriminatorLabel = mainActivity.getDiscriminantText();
		Assert.assertEquals("Discriminant: 1.0", discriminatorLabel);

		String solutionLabel = mainActivity.getSolution1Text();
		Assert.assertEquals("Root 1: 2.0", solutionLabel);

		String solution2Label = mainActivity.getSolution2Text();
		Assert.assertEquals("Root 2: 1.0", solution2Label);

	}

    @Test
    public void testSingleRootEquation() throws Throwable {

        EquationActivityObject mainActivity = new EquationActivityObject(mDevice);
        mainActivity.setCoefficientA("1");
        mainActivity.setCoefficientB("2");
        mainActivity.setCoefficientC("1");

		mainActivity.closeSoftKeyboard();

        mainActivity.clickCalculateButton();

        mainActivity.swipeUp();

        String discriminatorLabel = mainActivity.getDiscriminantText();
        Assert.assertEquals("Discriminant: 0.0", discriminatorLabel);

        String solutionLabel = mainActivity.getSolution1Text();
        Assert.assertEquals("Root 1: -1.0", solutionLabel);

        String solution2Label = mainActivity.getSolution2Text();
        Assert.assertEquals("Root 2:", solution2Label);

    }


}
