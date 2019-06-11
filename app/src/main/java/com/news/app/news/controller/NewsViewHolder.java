package com.news.app.news.controller;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.news.app.news.R;
import com.news.app.news.model.topstories.NewYorkTimesResponse;

public class NewsViewHolder extends RecyclerView.ViewHolder {
 
    public TextView title;
    public TextView description;
    public TextView updated_date;
    public ImageView image;
    //public WebView webView;
    public WebView webView;
    public String Siteurl;



    public NewsViewHolder(View itemView) {
        super(itemView);

        //title = (TextView) itemView.findViewById(R.id.post_title);
        description = (TextView) itemView.findViewById(R.id.post_description);
        updated_date = (TextView) itemView.findViewById(R.id.date);
        image = (ImageView) itemView.findViewById(R.id.image);


       // webView = (WebView) itemView.findViewById(R.id.webView);

        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(Siteurl);
            }

        });


    }
}
