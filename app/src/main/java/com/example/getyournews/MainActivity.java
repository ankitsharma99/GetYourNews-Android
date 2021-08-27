package com.example.getyournews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.getyournews.Models.ApiResponse;
import com.example.getyournews.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    private final OnFetchDataListener<ApiResponse> listener = new OnFetchDataListener<ApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
        }

        @Override
        public void onErrorMessage(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.rv_recyclerViewMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customAdapter = new CustomAdapter(this, list);

        recyclerView.setAdapter(customAdapter);
    }
}