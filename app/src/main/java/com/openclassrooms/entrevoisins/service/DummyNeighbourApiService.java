package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favorites = DummyNeighbourGenerator.generateFavorites();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param favorite
     */
    public void addFavorite(Neighbour favorite) {
        favorites.add(favorite);
    }




    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getFavorites() {
        for (Neighbour neighbour: neighbours) {
            if (neighbour.isFavorite()) {
                favorites.add(neighbour);
            }
        };
        return favorites;
    }

    /**
     * {@inheritDoc}
     * @param favorite
     */
    @Override
    public void deleteFavorite(Neighbour favorite) {
        favorites.remove(favorite);
    }

    /**
     * {@inheritDoc}
     * @param favorite
     */
    @Override
    public void createFavorite(Neighbour favorite) {
        favorites.add(favorite);
    }
}
