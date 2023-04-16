package com.aniketjain.weatherapp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import android.app.ActivityManager;
import android.content.Context;
import android.os.BatteryManager;
import android.os.SystemClock;
import android.util.Log;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest  {

    private ActivityManager manazer;
    @Rule
    public ActivityScenarioRule pravidlo = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void test() {
        BatteryManager manazer = (BatteryManager)
        InstrumentationRegistry.getInstrumentation().getTargetContext().getSystemService(Context.BATTERY_SERVICE);
        int bateria = manazer.getIntProperty(manazer.BATTERY_PROPERTY_CAPACITY);
        SystemClock.sleep(1 * 10 * 1000);
        int desat = manazer.getIntProperty(manazer.BATTERY_PROPERTY_CAPACITY);
        int spotreba = bateria - desat;
        Log.d("Bateria", "Zmena batérie v stave kľudu: " + spotreba + "%");
        onView(withId(R.id.city_et)).perform(click()).perform(typeText("Rome"));
        onView(withId(R.id.search_bar_iv)).perform(click());

        int proces = manazer.getIntProperty(manazer.BATTERY_PROPERTY_CAPACITY);
        int spotrebapouz = bateria - proces;
        Log.d("Bateria", "Zmena batérie po vykonaní vyhľadávania: " + spotrebapouz + "%");
    }
}