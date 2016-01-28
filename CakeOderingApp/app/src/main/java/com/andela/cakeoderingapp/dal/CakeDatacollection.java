package com.andela.cakeoderingapp.dal;

import com.andela.cakeoderingapp.models.Model;
import com.andela.cakeoderingapp.utilities.Constants;
import com.firebase.client.Firebase;

import java.util.List;

public class CakeDatacollection<T extends Model> implements DataCollection<T> {

    private Firebase firebase;
    private String childName;
    private Class<T> type;

    public CakeDatacollection(String childName, Class<T> type) {
        this.childName = childName;
        this.type = type;
        firebase = new Firebase(Constants.FIREBASE_URL);
    }

    @Override
    public void save(T data, DataCallback<T> callback) {
        firebase.child(childName)
                .child(data.getId())
                .setValue(data);
        if (callback !=null){
            callback.onSuccess(data.getId());
        }

    }

    @Override
    public void get(String id, DataCallback<T> callback) {

    }

    @Override
    public void getAll(DataCallback<List<T>> callback) {

    }

    @Override
    public void query(String path, String arg, DataCallback<List<T>> callback) {

    }
}
