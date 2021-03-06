package com.smlnskgmail.jaman.hashchecker.generator.ui;

import android.support.annotation.IdRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.smlnskgmail.jaman.hashchecker.MainActivity;
import com.smlnskgmail.jaman.hashchecker.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ScreenRunnerTest {

    @Rule
    public ActivityTestRule<MainActivity> menuActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void startScreenRunner() {
        showBottomSheet(R.id.hash_types);
        showBottomSheet(R.id.button_generate_from);
        showBottomSheet(R.id.button_hash_actions);

        showFragment(R.string.menu_settings_title);
        showFragment(R.string.menu_feedback_title);
    }

    private void showBottomSheet(int bottomSheetButtonResId) {
        Espresso.onView(ViewMatchers.withId(bottomSheetButtonResId)).perform(ViewActions.click());
        delayAndBack();
    }

    private void showFragment(@IdRes int menuTitleResId) {
        Espresso.openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        Espresso.onView(ViewMatchers.withText(InstrumentationRegistry.getTargetContext()
                .getString(menuTitleResId))).perform(ViewActions.click());
        delayAndBack();
    }

    private void delayAndBack() {
        secondDelay();
        Espresso.pressBack();
        secondDelay();
    }

    private void secondDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
