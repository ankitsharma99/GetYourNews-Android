package com.example.getyournews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.getyournews.Models.ApiResponse;
import com.example.getyournews.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Getting news for you...");
        progressDialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    private final OnFetchDataListener<ApiResponse> listener = new OnFetchDataListener<ApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
            progressDialog.dismiss();
        }

        @Override
        public void onErrorMessage(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.rv_recyclerViewMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customAdapter = new CustomAdapter(this, list, this);

        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
        .putExtra("data", headlines));

    }
}