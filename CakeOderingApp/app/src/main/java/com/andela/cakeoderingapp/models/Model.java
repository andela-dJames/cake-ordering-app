package com.andela.cakeoderingapp.models;

/**
 * Created by andela-jugba on 1/25/16.
 */
public class Model {

    private String id;
    private String name;

    protected Model() {

    }

    protected Model(String id) {
        this.id = id;
    }

    protected Model(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
