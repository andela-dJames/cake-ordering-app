package com.andela.cakeoderingapp.utilities;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageConverter {
    private String pathTofile;

    public ImageConverter(String pathTofile) {
        this.pathTofile = pathTofile;
    }

    private byte [] covertToByteArray() {
        Bitmap bm = BitmapFactory.decodeFile(pathTofile);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return baos.toByteArray();
    }

    public String convertToString() {
        return Base64.encodeToString(covertToByteArray(), Base64.DEFAULT);
    }

    private byte[] stringToByte(String url) throws IOException {
        return com.firebase.client.utilities.Base64.decode(url);

    }

    public Bitmap toBitmap(String url) throws IOException {
        int length = stringToByte(url).length;
        return BitmapFactory.decodeByteArray(stringToByte(url), 0, length);
    }

    public void encode( ImageProcessCallback callback){
      String result =  com.firebase.client.utilities.Base64.encodeBytes(covertToByteArray());
        callback.onSuccess(result);

    }

    public void decode(String url, ImageProcessCallback callback){
        try {
            Bitmap bitmap = toBitmap(url);
            callback.onSuccess(bitmap);
        } catch (IOException e) {
            callback.onError(e.getMessage());
            e.printStackTrace();
        }

    }
}
