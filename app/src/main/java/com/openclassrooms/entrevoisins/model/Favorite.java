package com.openclassrooms.entrevoisins.model;

/**
 * Created by ordinateur _ Khalid _  on 22/02/2022.
 */

import java.io.Serializable;
import java.util.Objects;

/**
 * Model object representing a Favorite
 */
public class Favorite implements Serializable {

    /**
     * Identifier
     */
    private long id;

    /**
     * Full name
     */
    private String name;

    /**
     * Avatar
     */
    private String avatarUrl;

    /**
     * Adress
     */
    private String address;

    /**
     * Phone number
     */
    private String phoneNumber;

    /**
     * About me
     */
    private String aboutMe;

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Favorite(long id, String name, String avatarUrl, String address,
                    String phoneNumber, String aboutMe) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.aboutMe = aboutMe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}