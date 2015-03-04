package com.example.equation2ndgrade;



import junit.framework.Assert;
import android.test.UiThreadTest;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MainActivityObject {

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
	
	

	public MainActivityObject() {
		
	}
	
	protected UiObject findByContentDescription(String cs) {
		UiObject view = new UiObject(new UiSelector().description(cs));

		Assert.assertTrue("Unable to detect view " + cs, view.exists());
		return view;
	}

	public void setCoefficientA(String value) throws UiObjectNotFoundException {

		UiObject coefficientAEditText = findByContentDescription(COEFFICIENT_A_CONTENT_DESC);
		coefficientAEditText.clearTextField();
		coefficientAEditText.setText(value);
	}

	public void setCoefficientB(String value) throws UiObjectNotFoundException {
		UiObject coefficientBEditText = findByContentDescription(COEFFICIENT_B_CONTENT_DESC);
		coefficientBEditText.clearTextField();
		coefficientBEditText.setText(value);
	}
	
	public void setCoefficientC(String value) throws UiObjectNotFoundException {
		UiObject coefficientCEditText = findByContentDescription(COEFFICIENT_C_CONTENT_DESC);
		coefficientCEditText.clearTextField();
		coefficientCEditText.setText(value);
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
