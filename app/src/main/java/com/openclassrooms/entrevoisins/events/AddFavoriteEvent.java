package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user add a favorite
 */
public class AddFavoriteEvent {

    /**
     * Favorite to add
     */
    public Neighbour favorite;

    /**
     * Constructor.
     * @param favorite
     */
    public AddFavoriteEvent(Neighbour favorite) {
        this.favorite = favorite;
    }
}
