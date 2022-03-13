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
import static org.junit.Assert.assertTrue;

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

    /**
     *  we ensure that a neighbour is set favorite
     */
    @Test
    public void setFavoriteWithSuccess() {
        Neighbour neighbourToSetFavorite = service.getNeighbours().get(0);
        service.addFavorite(neighbourToSetFavorite);
        Neighbour favorite = service.getFavorites().get(0);
        assertThat(neighbourToSetFavorite, sameInstance(favorite));
    }

    /**
     *  we ensure that favorites are displayed
     */
    @Test
    public void getFavoritesWithSuccess() {
        Neighbour neighbourToSetFavorite1 = service.getNeighbours().get(0);
        service.addFavorite(neighbourToSetFavorite1);
        Neighbour neighbourToSetFavorite2 = service.getNeighbours().get(1);
        service.addFavorite(neighbourToSetFavorite2);
        List<Neighbour> favorites = service.getFavorites();
        assertTrue(favorites.contains(neighbourToSetFavorite1));
        assertTrue(favorites.contains(neighbourToSetFavorite2));
    }

    /**
     *  we ensure that favorites are displayed
     */
    @Test
    public void getFavoritesWithSuccess2() {
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
    /**
     *  we ensure that a favorite is deleted
     */
    @Test
    public void deleteFavoriteWithSuccess() {
        Neighbour neighbourToSetFavorite = service.getNeighbours().get(2);
        service.addFavorite(neighbourToSetFavorite);
        Neighbour favoriteToDelete = service.getFavorites().get(0);
        service.deleteFavorite(favoriteToDelete);
        assertFalse(service.getFavorites().contains(favoriteToDelete));
    }

    /**
     *  we ensure that a neighbour is created
     */
    @Test
    public void createNeighboursWithSuccess() {
        Neighbour newNeighbour = new Neighbour(111, "Pedro", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "in the wood",
                "234566789", "and much more to be said");
        Neighbour createdNeighbour = service.createNeighbour(newNeighbour);
        List<Neighbour> neighbours = service.getNeighbours();
        assertTrue(neighbours.contains(newNeighbour));
}

}
