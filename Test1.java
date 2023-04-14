package com.aniketjain.weatherapp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import androidx.test.espresso.contrib.AccessibilityChecks;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class ExampleInstrumentedTest  {


    @Rule
    public ActivityScenarioRule podmienka =
            new ActivityScenarioRule<>(HomeActivity.class);


    @Before
    public void priprava() {
        AccessibilityChecks.enable();
    }

    @Test
    public void test() {
        onView(withId(R.id.city_et)).check(matches(withContentDescription("Enter name of a city")));
    }

    @Test
    public void testa() {
        onView(ViewMatchers.withId(R.id.name_tv))
                .check(matches(withText("Las Vegas")))
                .check(matches(withContentDescription("Current location")));
    }
}