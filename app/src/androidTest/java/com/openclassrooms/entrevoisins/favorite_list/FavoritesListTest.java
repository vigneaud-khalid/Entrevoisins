package com.openclassrooms.entrevoisins.favorite_list;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.DetailsActivity;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by  Khalid _  on 04/03/2022.
 */



/**
 * Test class for list of favorites
 */
@RunWith(AndroidJUnit4.class)
public class FavoritesListTest {


    //test Espresso vérifiant que l’onglet Favoris n’affiche que les voisins marqués comme favoris
    private ListNeighbourActivity mActivity;
    private DetailsActivity mDetailsActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);


    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying no item
     * and then after adding one favorite
     * We ensure that our recyclerview is displaying one item
     */
    @Test
    public void myFavoritesList_shouldBeEmpty_beforeAddingAFavorite_andThenShouldNotBeEmpty() {
        // myFavoritesList should be empty
        // onView(ViewMatchers.withId(R.id.list_neighbours)).check(matches(hasChildCount(0)));
        // When perform a click on a neighbour avatar to show details
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        // When perform a click on add to favorite icon
        onView(ViewMatchers.withId(R.id.details_favorite))
                //.perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
                .perform(click());

        // When perform a click on return icon
        onView(ViewMatchers.withId(R.id.details_back_arrow))
                .perform(click());
        // When perform a click on favorite fragment
        onView(ViewMatchers.withId(R.id.list_favorites))
                .perform(click());
        // Then : the number of element is 1
        onView(ViewMatchers.withId(R.id.list_favorites)).check(withItemCount(1));

    }
}