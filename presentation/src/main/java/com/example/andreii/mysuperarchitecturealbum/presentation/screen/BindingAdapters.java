package com.example.andreii.mysuperarchitecturealbum.presentation.screen;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingAdapters {

    @BindingAdapter({"app:url"})
    public static void loadImage(ImageView imageView, String imageUrl){
        Picasso.get().load(imageUrl).into(imageView);
    }
}
