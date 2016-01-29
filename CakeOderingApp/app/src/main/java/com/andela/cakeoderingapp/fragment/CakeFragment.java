package com.andela.cakeoderingapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andela.cakeoderingapp.R;
import com.andela.cakeoderingapp.adapter.CakeAdapter;
import com.andela.cakeoderingapp.dal.CakeDatacollection;
import com.andela.cakeoderingapp.dal.DataCallback;
import com.andela.cakeoderingapp.models.Cake;

import java.util.ArrayList;
import java.util.List;

public class CakeFragment  extends Fragment{

    private RecyclerView recyclerView;
    private List<Cake> cakes;
    private CakeAdapter cakeAdapter;

    public CakeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cake_fragment, container, false);
        initializeComponents(view);
        addItems();
        return view;
    }

    private void initializeComponents(View v){
        recyclerView = (RecyclerView) v.findViewById(R.id.activity_items);
        cakes = new ArrayList<>();
        cakeAdapter = new CakeAdapter(cakes, getContext());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanCount(2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(cakeAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void addItems() {
        CakeDatacollection<Cake> collection = new CakeDatacollection<>("cakes", Cake.class);
        collection.getAll(new DataCallback<List<Cake>>() {
            @Override
            public void onSuccess(List<Cake> value) {
                for (Cake cake : value) {
                    int index = findIndex(cake);
                    if (index < 0) {
                        cakes.add(cake);
                        cakeAdapter.notifyItemInserted(cakes.size()-1);
                    }

                    else {
                        cakes.set(index, cake);
                        cakeAdapter.notifyItemChanged(index);
                    }
                }

            }

            @Override
            public void onError(String error) {

            }
        });

    }

    private int findIndex(Cake cake) {
        for (int i = 0; i < cakes.size()-1; i++){
            if (cake.getId() == cakes.get(i).getId()){
                return i;
            }
        }
        return -1;
    }
}
