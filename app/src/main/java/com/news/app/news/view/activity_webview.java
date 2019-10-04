package com.news.app.news.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.news.app.news.R;

public class activity_webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent = getIntent();
        WebView webview = findViewById(R.id.webview);

        webview.loadUrl(intent.getStringExtra("WEBURL"));
    }
}
