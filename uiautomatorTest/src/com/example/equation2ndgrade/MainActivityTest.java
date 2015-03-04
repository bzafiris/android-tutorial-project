package com.example.equation2ndgrade;

//Import the uiautomator libraries
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * Test case that uses the uiautomator framework.
 * 
 * @author Vassilis Zafeiris
 *
 */
public class MainActivityTest extends UiAutomatorTestCase {

	public static String APP_NAME = "EquationSolvingApp";
	public static String APP_PACKAGE = "com.example.equation2ndgrade";
	/**
	 * The main activity of the application. It is initialized in the setup
	 * method
	 */
	UiObject equationsAppMainActivity;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		navigateToApp();
	}

	private void navigateToApp() throws UiObjectNotFoundException {
		// Simulate a short press on the HOME button.
		getUiDevice().pressHome();

		// Bring up the All Apps screen (requires English locale)
		UiObject allAppsButton = new UiObject(
				new UiSelector().description("Apps"));
		// Simulate a click to bring up the All Apps screen.
		allAppsButton.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		// Simulate a click to enter the Apps tab.
		appsTab.click();

		// Simulate a user swiping until finding the application
		UiScrollable appViews = new UiScrollable(
				new UiSelector().scrollable(true));

		// Create a UiSelector to find the Equation2ndGrade app and simulate
		// a user click to launch the app.
		UiObject equationsApp = appViews.getChildByText(new UiSelector()
				.className(android.widget.TextView.class.getName()), APP_NAME);
		equationsApp.clickAndWaitForNewWindow();

		// Validate that the package name is the expected one
		equationsAppMainActivity = new UiObject(
				new UiSelector().packageName(APP_PACKAGE));

		assertTrue("Unable to detect EquationSolvingApp",
				equationsAppMainActivity.exists());

	}

	public void testDoubleRootEquation() throws Throwable {

		MainActivityObject mainActivity = new MainActivityObject();
		mainActivity.setCoefficientA("1");
		mainActivity.setCoefficientB("-3");
		mainActivity.setCoefficientC("2");

		mainActivity.clickCalculateButton();

		String discriminatorLabel = mainActivity.getDiscriminantText();
		assertEquals("Discriminant: 1.0", discriminatorLabel);

		String solutionLabel = mainActivity.getSolution1Text();
		assertEquals("Root 1: 2.0", solutionLabel);

		String solution2Label = mainActivity.getSolution2Text();
		assertEquals("Root 2: 1.0", solution2Label);

	}

	@Override
	protected void tearDown() throws Exception {

		
//		getUiDevice().pressDelete();
		super.tearDown();

	}
}
