package com.news.app.news;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void viewPagerSwapping() {
        onView((withId(R.id.viewpager))).check(matches(isDisplayed()));
        onView(withId(R.id.viewpager)).perform(swipeLeft());
        onView(withId(R.id.viewpager)).perform(swipeLeft());
    }


    @Test
    public void scrollingFunctionality() {
        // onView(ViewMatchers.withId(R.id.viewpager)).perform(ViewActions.swipeUp());

        onView(withId(R.id.recycler_id)).perform(RecyclerViewActions.scrollToPosition(3));
    }


    @Test
    public void searchFunctionality() {
        /* From the main menu, click on the Search Icon */
        onView(withId(R.id.search)).perform(click());

        /*Once the search window pops up, clear the existing displayed text, then input/type the text value "Trump" */
        onView(withId(R.id.searchText)).perform(clearText(), typeText("Trump"));

        /* Select two textBoxes as criteria */
        onView(withId(R.id.travel_checkbox)).perform(click());
        onView(withId(R.id.politic_checkbox)).perform(click());

        /* Initiate the search by clicking on the search button */
        onView(withId(R.id.searchButton)).perform(click());
    }
}
