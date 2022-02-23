package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyFavoriteApiService implements FavoriteApiService {

    private List<Neighbour> favorites = DummyFavoriteGenerator.generateFavorites();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getFavorites() {
        return favorites;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteFavorite(Neighbour favorite) {
        favorites.remove(favorite);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createFavorite(Neighbour favorite) {
        favorites.add(favorite);
    }
}
