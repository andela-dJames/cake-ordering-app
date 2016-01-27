package com.andela.cakeoderingapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by andela-jugba on 1/27/16.
 */
public class SharedPreferenceManager {


    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public SharedPreferenceManager(Context context) {

        sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPref.edit();
    }

    public void saveCurrentUser(String currentUser) {

        editor.putString(Constants.CURRENT_USER, currentUser);
        editor.commit();
    }

    public String retrieveCurrentUser() {

        return sharedPref.getString(Constants.CURRENT_USER, Constants.DEFAULT_USER);
    }

}
