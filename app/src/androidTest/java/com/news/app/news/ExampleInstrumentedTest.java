package com.news.app.news;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xml.sax.Locator;

import androidx.test.espresso.ViewAction;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webClick;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webClick;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    private static final int ITEM_BELOW_THE_FOLD = 4;

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
      onView(withId(R.id.recycler_id))            // withId(R.id.my_view) is a ViewMatcher
              .perform(click())               // click() is a ViewAction
              .check(matches(isDisplayed()));
  }



    @Test
    public void searchFunctionality() {
        /* From the main menu, click on the Search Icon */
        onView(withId(R.id.search)).perform(click());

        /*Once the search window pops up, clear the existing displayed text, then input/type the text value "Trump" */
        onView(withId(R.id.searchText)).perform(clearText(), typeText("Sarah Sanders"));

        /* Select two textBoxes as criteria */
        onView(withId(R.id.travel_checkbox)).perform(click());
        onView(withId(R.id.politic_checkbox)).perform(click());

        /* Initiate the search by clicking on the search button */
        onView(withId(R.id.searchButton)).perform(click());
    }


    @Test
    public void webViewClick() {
    }
}
