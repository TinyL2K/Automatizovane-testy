package com.jenil.expense_manager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.jenil.expense_manager.activity.Login;
import com.jenil.expense_manager.activity.NextActivity;
import com.jenil.expense_manager.activity.SignUp;


@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule pravidlo1 = new ActivityScenarioRule<>(Login.class);
    @Rule
    public ActivityScenarioRule pravidlo2 = new ActivityScenarioRule<>(SignUp.class);
    @Rule
    public ActivityScenarioRule pravidlo3 = new ActivityScenarioRule<>(NextActivity.class);

    @Test
    public void test()
    {
        onView(withId(R.id.signup_screen)).perform(click());
        onView(withId(R.id.Username_reg)).perform(click()).perform(typeText("Vladislav"));
        onView(withId(R.id.Password_reg)).perform(click()).perform(typeText("heslo"));
        onView(withId(R.id.Repassword_reg)).perform(click()).perform(typeText("heslo"));
        onView(withId(R.id.reg_btn)).perform(click());
        onView(withId(R.id.UsernameLogin)).perform(click()).perform(typeText("Vladislav"));
        onView(withId(R.id.PasswordLogin)).perform(click()).perform(typeText("heslo"));
        closeSoftKeyboard();
        onView(withId(R.id.next_screen)).perform(click());
        onView(ViewMatchers.withText("Hello World")).check(matches(ViewMatchers.isDisplayed()));
    }

}
