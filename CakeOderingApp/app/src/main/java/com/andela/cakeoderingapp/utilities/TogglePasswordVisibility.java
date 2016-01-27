package com.andela.cakeoderingapp.utilities;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.andela.cakeoderingapp.R;

/**
 * Created by andela-jugba on 1/27/16.
 */
public class TogglePasswordVisibility extends ImageButton {

    private int passwordVisibleImageResource;

    private int passwordInvisibleImageResource;

    private int passwordEditTextId;

    public TogglePasswordVisibility(Context context, AttributeSet set) {
        super(context,set);

        //TypedArray attrs = context.getTheme().obtainStyledAttributes(set, R.styleable.TogglePasswordVisibilityButton, 0, 0);

        try {
//            passwordVisibleImageResource = attrs.getResourceId(R.styleable.TogglePasswordVisibilityButton_passwordVisibleImageResource, 0);
//
//            passwordInvisibleImageResource = attrs.getResourceId(R.styleable.TogglePasswordVisibilityButton_passwordInvisibleImageResource, 0);
//
//            passwordEditTextId = attrs.getResourceId(R.styleable.TogglePasswordVisibilityButton_passwordEditText, 0);

            setImageResource(passwordInvisibleImageResource);

        } finally {
            //attrs.recycle();
        }

        //attachOnToggleEventHandler();
    }
}
