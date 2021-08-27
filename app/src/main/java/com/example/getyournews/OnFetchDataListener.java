package com.example.getyournews;

import com.example.getyournews.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<ApiResponse> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onErrorMessage(String message);
}
