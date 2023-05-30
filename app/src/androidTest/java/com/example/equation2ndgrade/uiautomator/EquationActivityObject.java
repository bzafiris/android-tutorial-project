package com.example.equation2ndgrade.uiautomator;



import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import junit.framework.Assert;



public class EquationActivityObject {

	UiDevice mDevice;
	/**
	 * Content descriptions that characterize the MainActivity UI elements (see res/layout/activity_main.xml layout file) 
	 */
	private static final String COEFFICIENT_A_CONTENT_DESC = "Coefficient a";
	private static final String COEFFICIENT_B_CONTENT_DESC = "Coefficient b";
	private static final String COEFFICIENT_C_CONTENT_DESC = "Coefficient c";
	private static final String DISCRIMINANT_CONTENT_DESC = "Discriminant result";
	private static final String SOLUTION_1_CONTENT_DESC = "Solution 1";
	private static final String SOLUTION_2_CONTENT_DESC = "Solution 2";
	private static final String BUTTON_CONTENT_DESC = "Calculate solution button";
	
	

	public EquationActivityObject(UiDevice mDevice) {
		this.mDevice = mDevice;
	}
	
	protected UiObject findByText(String cs) {
		UiObject view = mDevice.findObject(new UiSelector().text(cs));

		Assert.assertTrue("Unable to detect view " + cs, view.exists());
		return view;
	}

    protected UiObject findByContentDescription(String cs) {
        UiObject view = mDevice.findObject(new UiSelector().descriptionContains(cs));

        Assert.assertTrue("Unable to detect view " + cs, view.exists());
        return view;
    }

	public void setCoefficientA(String value) throws UiObjectNotFoundException {

		UiObject coefficientAEditText = findByText(COEFFICIENT_A_CONTENT_DESC);
		coefficientAEditText.clearTextField();
		coefficientAEditText.setText(value);
	}

	public void setCoefficientB(String value) throws UiObjectNotFoundException {
		UiObject coefficientBEditText = findByText(COEFFICIENT_B_CONTENT_DESC);
		coefficientBEditText.clearTextField();
		coefficientBEditText.setText(value);
	}
	
	public void setCoefficientC(String value) throws UiObjectNotFoundException {
		UiObject coefficientCEditText = findByText(COEFFICIENT_C_CONTENT_DESC);
		coefficientCEditText.clearTextField();
		coefficientCEditText.setText(value);
	}

	public void closeSoftKeyboard(){
		mDevice.pressBack();
	}

	public void swipeUp(){
		mDevice.swipe(100, 100, 100, 50, 2);
	}

	public String getDiscriminantText() throws UiObjectNotFoundException {
		
		UiObject diakrinousaTextView = findByContentDescription(DISCRIMINANT_CONTENT_DESC);
		String text = diakrinousaTextView.getText();
		return text;
		
	}
	
	public String getSolution1Text() throws UiObjectNotFoundException {
		
		UiObject solution1TextView = findByContentDescription(SOLUTION_1_CONTENT_DESC);
		String text = solution1TextView.getText();
		return text;
		
	}
	
	public String getSolution2Text() throws UiObjectNotFoundException {
		
		UiObject solution2TextView = findByContentDescription(SOLUTION_2_CONTENT_DESC);
		String text = solution2TextView.getText();
		return text;
		
	}
	
	public void clickCalculateButton() throws UiObjectNotFoundException {
		UiObject button = findByContentDescription(BUTTON_CONTENT_DESC);
		button.click();
	}


}
