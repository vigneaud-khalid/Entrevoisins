package com.openclassrooms.entrevoisins;
/**
 * Created by ordinateur _ Khalid _  on 04/03/2022.
 */
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;


import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
//import static android.support.test.espresso.assertion.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for Neighbour Details
 */
@RunWith(AndroidJUnit4.class)
public class NeighbourDetailsTest {

    private DetailsActivity mActivity;

    @Rule
    public ActivityTestRule<DetailsActivity> mActivityRule =
            new ActivityTestRule(DetailsActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void showNeighbourDetails() {
        // Given : We display the the neighbour details
        onView(ViewMatchers.withId(R.id.details_textview_descriptionName)).check(matches(isDisplayed));
        // When  onView(ViewMatchers.withId(R.id.list_neighbours))
        // onView(ViewMatchers.withId(R.id.details_textview_descriptionName)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : TextView is filled with the neighbour name
        onView(ViewMatchers.withId(R.id.details_textview_descriptionName)).check(isNotEmpty);
    }

    @After
    public void tearDown() {
        // After Test case Execution
    }
}