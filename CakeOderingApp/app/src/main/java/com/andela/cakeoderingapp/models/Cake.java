package com.andela.cakeoderingapp.models;

/**
 * Created by andela-jugba on 1/25/16.
 */
public class Cake extends Model {

    private Category category;
    private String snapshot;

    public Cake() {

    }

    public Cake(String id) {
        super(id);
    }

    public Cake(String id,String name) {
        super(id,name);
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
