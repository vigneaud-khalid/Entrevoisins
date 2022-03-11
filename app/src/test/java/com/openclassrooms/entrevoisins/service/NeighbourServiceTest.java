package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

//    test unitaire pour la mise en favori dans le Service
    @Test
    public void setFavoriteWithSuccess() {
        Neighbour neighbourToSetFavorite = service.getNeighbours().get(0);
        service.addFavorite(neighbourToSetFavorite);
        Neighbour favorite = service.getFavorites().get(0);
        assertThat(neighbourToSetFavorite, sameInstance(favorite));
    }

     // test unitaire sur le getFavorites dans le Service
    @Test
    public void getFavoritesWithSuccess() {
        Neighbour neighbourToSetFavorite1 = service.getNeighbours().get(0);
        service.addFavorite(neighbourToSetFavorite1);
        Neighbour neighbourToSetFavorite2 = service.getNeighbours().get(1);
        service.addFavorite(neighbourToSetFavorite2);
        List<Neighbour> favorites = service.getFavorites();
        List<Neighbour> expectedFavorites=null;
        expectedFavorites.add(neighbourToSetFavorite1);
        expectedFavorites.add(neighbourToSetFavorite2);
        assertThat(favorites, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavorites.toArray()));
        assertThat(favorites, is(expectedFavorites));

    }



}
