package com.andela.cakeoderingapp.dal;

/**
 * Created by andeladev on 28/01/2016.
 */
public interface DataCallback<T> {
    void onSuccess(String value);
    void onError(String error);
}
