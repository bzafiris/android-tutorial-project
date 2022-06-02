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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.equation2ndgrade.EquationActivity;
import com.example.equation2ndgrade.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * JUnit4 test class based on the Espresso android testing framework
 * @author Vassilis Zafeiris
 *
 */
@RunWith(AndroidJUnit4.class)
public class EquationActivityPageObjectTest {

    /**
     * The rule launches the activity before each test method annotated with @Test and
     * before any method annotated with @Before. The framework handles shutting down the activity
     * after each test.
     */
    @Rule
    public ActivityScenarioRule<EquationActivity> mActivityRule = new ActivityScenarioRule<>(
            EquationActivity.class);
    private Context context;
    private EquationActivityObject equationActivity;

    @Before
    public void setup(){
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        equationActivity = new EquationActivityObject(context);
    }

    @Test
    public void testNoSolutionEquation() throws Throwable {

        equationActivity
                .fillCoefficientA("3")
                .fillCoefficientB("-1")
                .fillCoefficientC("1")
                .calculateSolution()
                .assertHasNoSolution();
    }

    @Test
    public void testDoubleRootEquation() throws Throwable {

        equationActivity
                .fillCoefficientA("1")
                .fillCoefficientB("-3")
                .fillCoefficientC("2")
                .calculateSolution()
                .assertHasRoot1(2.0)
                .assertHasRoot2(1.0);

    }

    @Test
    public void testSingleRootEquation() throws Throwable {

        equationActivity
                .fillCoefficientA("1")
                .fillCoefficientB("2")
                .fillCoefficientC("1")
                .calculateSolution()
                .assertHasSingleRoot(-1.0);

    }


}
