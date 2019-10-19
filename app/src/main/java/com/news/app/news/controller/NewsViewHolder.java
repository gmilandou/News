package com.news.app.news.controller;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.news.app.news.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    //public TextView title;
    final TextView description;
    final TextView updated_date;
    final ImageView image;
    //public WebView webView;
    //public WebView webView;
    //public String Siteurl;
    final LinearLayout mcontent;
    public final TextView section;


    NewsViewHolder(View itemView) {
        super(itemView);

        //title = (TextView) itemView.findViewById(R.id.post_title);
        description = itemView.findViewById(R.id.post_description);
        updated_date = itemView.findViewById(R.id.date);
        image = itemView.findViewById(R.id.image);
        mcontent = itemView.findViewById(R.id.mcontent);
        section = itemView.findViewById(R.id.post_section);
        // webView = (WebView) itemView.findViewById(R.id.webView);


    }
}
