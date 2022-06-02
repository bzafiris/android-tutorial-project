package com.example.equation2ndgrade;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * JUnit4 test class based on the Espresso android testing framework
 * @author Vassilis Zafeiris
 *
 */
@RunWith(AndroidJUnit4.class)
public class EquationActivityEspressoTest {

    /**
     * The rule launches the activity before each test method annotated with @Test and
     * before any method annotated with @Before. The framework handles shutting down the activity
     * after each test.
     */
    @Rule
    public ActivityScenarioRule<EquationActivity> mActivityRule = new ActivityScenarioRule<>(
            EquationActivity.class);


    @Test
    public void testNoSolutionEquation() throws Throwable {

        onView(withHint("Coefficient a")).perform(clearText());
        onView(withHint("Coefficient a")).perform(typeText("3"));

        onView(withHint("Coefficient b")).perform(clearText());
        onView(withHint("Coefficient b")).perform(typeText("-1"));

        onView(withHint("Coefficient c")).perform(clearText());
        onView(withHint("Coefficient c")).perform(typeText("1"));

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_calculate)).perform(click());

        onView(withId(R.id.textRoot1)).check(matches(withText("Root 1:")));
        onView(withId(R.id.textRoot2)).check(matches(withText("Root 2:")));

    }

    @Test
    public void testDoubleRootEquation() throws Throwable {

        onView(withHint("Coefficient a")).perform(clearText());
        onView(withHint("Coefficient a")).perform(typeText("1"));

        onView(withHint("Coefficient b")).perform(clearText());
        onView(withHint("Coefficient b")).perform(typeText("-3"));

        onView(withHint("Coefficient c")).perform(clearText());
        onView(withHint("Coefficient c")).perform(typeText("2"));

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_calculate)).perform(click());

        onView(withId(R.id.textDiscriminant)).check(matches(withText("Discriminant: 1.0")));
        onView(withId(R.id.textRoot1)).check(matches(withText("Root 1: 2.0")));
        onView(withId(R.id.textRoot2)).check(matches(withText("Root 2: 1.0")));

    }

    @Test
    public void testSingleRootEquation() throws Throwable {

        onView(withHint("Coefficient a")).perform(clearText());
        onView(withHint("Coefficient a")).perform(typeText("1"));

        onView(withHint("Coefficient b")).perform(clearText());
        onView(withHint("Coefficient b")).perform(typeText("2"));

        onView(withHint("Coefficient c")).perform(clearText());
        onView(withHint("Coefficient c")).perform(typeText("1"));

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_calculate)).perform(click());

        onView(withId(R.id.textDiscriminant)).check(matches(withText("Discriminant: 0.0")));
        onView(withId(R.id.textRoot1)).check(matches(withText("Root 1: -1.0")));
        onView(withId(R.id.textRoot2)).check(matches(withText("Root 2:")));

    }


}
