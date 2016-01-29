package com.andela.cakeoderingapp.models;

/**
 * Created by andela-jugba on 1/26/16.
 */
public class User extends Model {

    private String fullName;
    private String email;
    private String residentialAddress;
    private String profilePictureUrl;

    public User() {

    }

    public User(String id) {

        super(id);
    }

    public User (String id, String name) {

        super(id,name);

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
