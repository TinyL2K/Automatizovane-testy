package com.jenil.expense_manager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.content.Context;
import android.os.BatteryManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import com.jenil.expense_manager.activity.Login;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule podmienka = new ActivityScenarioRule<>(Login.class);

    @Test
    public void testIdleBatteryUsage() {
        BatteryManager manazer = (BatteryManager) InstrumentationRegistry.getInstrumentation().getTargetContext().getSystemService(Context.BATTERY_SERVICE);
        int bateria = manazer.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        SystemClock.sleep(120 * 1000);
        int dva = manazer.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        int spotreba = bateria - dva;
        Log.d("Bateria", "Zmena batérie v stave kľudu: " + spotreba + "%");

        onView(withId(R.id.signup_screen)).perform(click());
        SystemClock.sleep(5 * 1000);

        onView(withId(R.id.Username_reg)).perform(click()).perform(typeText("Vladimir"));
        SystemClock.sleep(5 * 1000);

        onView(withId(R.id.Password_reg)).perform(click()).perform(typeText("heslo"));
        SystemClock.sleep(5 * 1000);

        onView(withId(R.id.Repassword_reg)).perform(click()).perform(typeText("heslo"));
        onView(withId(R.id.reg_btn)).perform(click());
        SystemClock.sleep(5 * 1000);

        onView(withId(R.id.UsernameLogin)).perform(click()).perform(typeText("Vladimir"));
        SystemClock.sleep(5 * 1000);

        onView(withId(R.id.PasswordLogin)).perform(click()).perform(typeText("heslo"));
        closeSoftKeyboard();

        onView(withId(R.id.next_screen)).perform(click());

        int pouz = manazer.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        int spotrebapouz = bateria - pouz;
        Log.d("Bateria", "Zmena batérie v stave kľudu: " + spotrebapouz + "%");
    }
}