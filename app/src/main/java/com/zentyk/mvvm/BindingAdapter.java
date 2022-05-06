package com.zentyk.mvvm;

import android.view.View;
import android.widget.TextView;

public class BindingAdapter {
    @androidx.databinding.BindingAdapter("visible")
    public static void setVisible(View view, boolean visible) {
        if(visible) {
            view.setVisibility(View.VISIBLE);
        }
        else {
            view.setVisibility(View.GONE);
        }
    }

    @androidx.databinding.BindingAdapter({"visibility","size"})
    public static void setSize(TextView view, boolean visible, float size) {
        if(visible) {
            view.setVisibility(View.VISIBLE);
        }
        else {
            view.setVisibility(View.GONE);
        }
        view.setTextSize(size);
    }
}