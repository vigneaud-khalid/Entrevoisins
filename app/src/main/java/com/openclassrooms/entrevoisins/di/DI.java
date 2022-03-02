package com.openclassrooms.entrevoisins.di;

import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import com.openclassrooms.entrevoisins.service.DummyFavoriteApiService;
import com.openclassrooms.entrevoisins.service.FavoriteApiService;

/**
 * Dependency injector to get instance of services
 */
public class DI {

    private static NeighbourApiService service = new DummyNeighbourApiService();

    /**
     * Get an instance on @{@link NeighbourApiService}
     * @return
     */
    public static NeighbourApiService getNeighbourApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link NeighbourApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static NeighbourApiService getNewInstanceApiService() {
        return new DummyNeighbourApiService();
    }


/*    private static FavoriteApiService serviceF = new DummyFavoriteApiService();

    *//**
     * Get an instance on @{@link FavoriteApiService}
     * @return
     *//*
    public static FavoriteApiService getFavoriteApiService() {
        return serviceF;
    }

    *//**
     * Get always a new instance on @{@link FavoriteApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     *//*
    public static FavoriteApiService getNewInstanceApiServiceF() {
        return new DummyFavoriteApiService();
    }*/
}
