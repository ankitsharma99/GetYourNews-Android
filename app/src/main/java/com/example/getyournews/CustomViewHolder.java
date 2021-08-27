package com.example.getyournews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView tv_title;
    TextView tv_source;
    ImageView img_headline;
    CardView cv_mainContainer;      //on click listener for the card view

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        //getting hold of all the views
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_source = itemView.findViewById(R.id.tv_source);
        img_headline = itemView.findViewById(R.id.img_headline);
        cv_mainContainer = itemView.findViewById(R.id.cv_mainContainer);


    }

}
