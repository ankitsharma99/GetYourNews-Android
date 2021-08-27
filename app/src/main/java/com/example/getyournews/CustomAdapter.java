package com.example.getyournews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getyournews.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    List<NewsHeadlines> headlines;      //as articles are in the form of json array

    public CustomAdapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomViewHolder view = new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false));
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_title.setText(headlines.get(position).getTitle());
        holder.tv_source.setText(headlines.get(position).getSource().getName());

        String urlToImg = headlines.get(position).getUrlToImage();
        if(urlToImg != null) {
            Picasso.get().load(urlToImg).into(holder.img_headline);
        }
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
