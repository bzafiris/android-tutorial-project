package com.example.equation2ndgrade.espresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.espresso.Espresso;

import com.example.equation2ndgrade.R;

/**
 * Should be refactored to a real Activity Object.
 * Now it just contains utility methods
 * @author Vassilis Zafeiris
 *
 */
public class EquationActivityObject {

	Context ctx;

	public EquationActivityObject(Context ctx) {
		this.ctx = ctx;
	}

	public EquationActivityObject fillCoefficientA(String value){
		fillEdiTextWithHint("Coefficient a", value);
		return this;
	}

	public EquationActivityObject fillCoefficientB(String value){
		fillEdiTextWithHint("Coefficient b", value);
		return this;
	}

	public EquationActivityObject fillCoefficientC(String value){
		fillEdiTextWithHint("Coefficient c", value);
		return this;
	}

	private void fillEdiTextWithHint(String hint, String value){
		onView(withHint(hint)).perform(clearText());
		onView(withHint(hint)).perform(typeText(value));
	}

	public EquationActivityObject calculateSolution(){
		Espresso.closeSoftKeyboard();
		onView(withId(R.id.btn_calculate)).perform(click());
		return this;
	}

	public EquationActivityObject assertHasRoot1(double value){
		String root1Label = formatRoot1Label(value);
		onView(withId(R.id.textRoot1)).check(matches(withText(root1Label)));
		return this;
	}

	public EquationActivityObject assertHasRoot2(double value){
		String root2Label = formatRoot2Label(value);
		onView(withId(R.id.textRoot2)).check(matches(withText(root2Label)));
		return this;
	}

	public EquationActivityObject assertHasSingleRoot(double value){
		assertHasRoot1(value);
		onView(withId(R.id.textRoot2)).check(matches(withText("Root 2:")));
		return this;
	}

	public EquationActivityObject assertHasNoSolution(){
		onView(withId(R.id.textRoot1)).check(matches(withText("Root 1:")));
		onView(withId(R.id.textRoot2)).check(matches(withText("Root 2:")));
		return this;
	}

	private String formatRoot1Label(double root){
		StringBuffer buffer = new StringBuffer(ctx.getResources().getString(R.string.label_root1));
		if (Double.isNaN(root)){
			return buffer.toString();
		}
		buffer.append(" ");
		buffer.append(Double.toString(root));
		return buffer.toString();
	}
	
	private String formatRoot2Label(double root){
		StringBuffer buffer = new StringBuffer(ctx.getResources().getString(R.string.label_root2));

		if (Double.isNaN(root)){
			return buffer.toString();
		}
		buffer.append(" ");
		buffer.append(Double.toString(root));
		return buffer.toString();
	}
	
}
