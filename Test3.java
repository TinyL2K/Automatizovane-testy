package com.aniketjain.weatherapp;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest  {


    @Rule
    public ActivityScenarioRule pravidlo = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void test() {
        ViewInteraction tlacitko = Espresso.onView(ViewMatchers.withId(R.id.mic_search_id));
        try {
            tlacitko.perform(ViewActions.click());
        } catch (PerformException e) {
            Assert.fail(e.getMessage());
        } } }