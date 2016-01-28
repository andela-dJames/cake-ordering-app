package com.andela.cakeoderingapp.utilities;

import android.graphics.Bitmap;

/**
 * Created by andeladev on 28/01/2016.
 */
public interface ImageProcessCallback {
    void onSuccess(String url);
    void onError(String error);
    void onSuccess(Bitmap bitmap);
}
