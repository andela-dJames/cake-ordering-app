package com.andela.cakeoderingapp.models;

import java.util.List;

/**
 * Created by andela-jugba on 1/25/16.
 */
public class Category extends Model{

    private String imageUrl;

    private String description;

    public Category() {

    }

    public Category(String id, String name) {
        super(id, name);
    }

    private List<Cake>cakes;

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
