package com.andela.cakeoderingapp.authentication;

/**
 * Created by andela-jugba on 1/26/16.
 */
public interface EmailPasswordAuth {

    void signUp(String email, String password, AuthCallBack authcallback);
    void signIn(String email, String password, AuthCallBack authcallback);
}
