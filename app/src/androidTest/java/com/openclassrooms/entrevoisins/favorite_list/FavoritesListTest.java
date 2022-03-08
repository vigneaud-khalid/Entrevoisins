package com.openclassrooms.entrevoisins.favorite_list;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;


/**
 * Created by ordinateur _ Khalid _  on 04/03/2022.
 */



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class FavoritesListTest {
    //test Espresso vérifiant que l’onglet Favoris n’affiche que les voisins marqués comme favoris

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);


}