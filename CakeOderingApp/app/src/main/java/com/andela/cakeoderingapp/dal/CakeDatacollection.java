package com.andela.cakeoderingapp.dal;

import com.andela.cakeoderingapp.models.Model;
import com.andela.cakeoderingapp.utilities.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
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
            callback.onSuccess(data);
        }

    }

    @Override
    public void get(String id, DataCallback<T> callback) {

    }

    @Override
    public void getAll(final DataCallback<List<T>> callback) {

        firebase.child(childName)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        List<T> data = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            data.add(snapshot.getValue(type));
                        }
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        callback.onError(firebaseError.getMessage());
                    }
                });

    }

    @Override
    public void query(String path, String arg, DataCallback<List<T>> callback) {

    }
}
