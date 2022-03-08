package com.openclassrooms.entrevoisins.neighbour_details;
/**
 * Created by ordinateur _ Khalid _  on 04/03/2022.
 */
import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
//import static android.support.test.espresso.intent.Intents.intended;
//import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.DetailsActivity;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;


import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for Neighbour Details
 */
@RunWith(AndroidJUnit4.class)
public class NeighbourDetailsTest {

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void showNeighbourDetailsDisplayed() {
        // Given : We display the the neighbour details
        // When perform a click on a neighbour avatar
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        // Then : We open DetailsActivity and show the details screen is displayed
        onView(ViewMatchers.withId(R.id.details_textview_descriptionName)).check(matches(isDisplayed()));

    }

    @Test
    public void showNeighbourDetailsNameMatches() {
        // Given : We display the the neighbour name
        // When perform a click on a neighbour avatar
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        // Then : We open DetailsActivity and show the name of the chosen neighbour
        onView(ViewMatchers.withId(R.id.details_textview_descriptionName)).check(matches(withText("Caroline")));
    }

    @After
    public void tearDown() {
        // After Test case Execution
    }
}