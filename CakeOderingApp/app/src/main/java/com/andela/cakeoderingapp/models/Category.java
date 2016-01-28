package com.andela.cakeoderingapp.models;

import java.util.List;

/**
 * Created by andela-jugba on 1/25/16.
 */
public class Category extends Model{

    public String description;
    public String imageUrl;

    public Category() {

    }

    public Category(String id, String name) {
        super(id, name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
