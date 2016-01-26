package com.andela.cakeoderingapp.utilities;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by andela-jugba on 1/26/16.
 */
public class SoftKeyboard {

    public static void hide(Activity activity) {

        View currentFocus = activity.getCurrentFocus();

        if (currentFocus != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

}
