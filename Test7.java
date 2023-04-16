package com.aniketjain.weatherapp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertTrue;

import android.app.ActivityManager;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest  {

    private ActivityManager manazer;
    @Rule
    public ActivityScenarioRule pravidlo = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void test() {
        onView(withId(R.id.city_et)).perform(click()).perform(typeText("Bratislava"));
        onView(withId(R.id.search_bar_iv)).perform(click());
        int pamat = manazer.getMemoryClass();
        assertTrue(pamat < 128);
    }
}