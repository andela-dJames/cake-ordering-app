package com.andela.cakeoderingapp.utilities;

import android.content.Context;
import android.content.Intent;

/**
 * Created by andela-jugba on 1/26/16.
 */
public class Launcher {

    public static void launchActivity(Context context, Class<?> activity) {

        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
}
