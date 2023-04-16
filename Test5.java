package com.jenil.expense_manager;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.jenil.expense_manager.activity.Login;


@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule pravidlo = new ActivityScenarioRule<>(Login.class);

    @Test
    public void test() {
        Espresso.onView(ViewMatchers.withId(R.id.logo_image)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
