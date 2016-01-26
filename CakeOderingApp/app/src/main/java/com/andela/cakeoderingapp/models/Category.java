package com.andela.cakeoderingapp.models;

import java.util.List;

/**
 * Created by andela-jugba on 1/25/16.
 */
public class Category extends Model{

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
}
