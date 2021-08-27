package com.example.getyournews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getyournews.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView tv_title, tv_author, tv_time, tv_detail, tv_content;
    ImageView img_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        getSupportActionBar().hide();

        tv_title = findViewById(R.id.tv_detailsTitle);
        tv_author = findViewById(R.id.tv_detailAuthor);
        tv_time = findViewById(R.id.tv_detailTime);
        tv_detail = findViewById(R.id.tv_detailDetail);
        tv_content = findViewById(R.id.tv_detailContent);

        img_news = findViewById(R.id.img_detailsNews);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        tv_title.setText(headlines.getTitle());
        tv_author.setText(headlines.getAuthor());
        tv_time.setText(headlines.getPublishedAt());
        tv_detail.setText(headlines.getDescription());
        tv_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

    }
}