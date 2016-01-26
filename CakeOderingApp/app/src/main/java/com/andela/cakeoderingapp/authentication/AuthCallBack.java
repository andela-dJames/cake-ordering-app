package com.andela.cakeoderingapp.authentication;

import com.andela.cakeoderingapp.models.User;

/**
 * Created by andela-jugba on 1/26/16.
 */
public interface AuthCallBack {

    void onSucess(User user);

    void onCancel();

    void onFailure(Exception e);

    void onError(String errorMessage);
}
