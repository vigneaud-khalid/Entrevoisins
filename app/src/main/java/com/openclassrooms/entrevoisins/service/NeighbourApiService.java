package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     * @return
     */
    Neighbour createNeighbour(Neighbour neighbour);

    /**
     * Add a favorite
     * @param favorite
     */
    void addFavorite(Neighbour favorite);



    /**
     * Get all my FavoriteNeighbours
     * @return {@link List}
     */
    List<Neighbour> getFavorites();

    /**
     * Deletes a FavoriteNeighbour
     * @param favorite
     */
    void deleteFavorite(Neighbour favorite);

}
