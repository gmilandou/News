package com.news.app.news.controller;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.news.app.news.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {
 
    public TextView title;
    public TextView description;
    public TextView updated_date;
    public ImageView image;
    //public WebView webView;
    public WebView webView;
    public String Siteurl;
    public LinearLayout mcontent ;
    public TextView section;



    public NewsViewHolder(View itemView) {
        super(itemView);

        //title = (TextView) itemView.findViewById(R.id.post_title);
        description = (TextView) itemView.findViewById(R.id.post_description);
        updated_date = (TextView) itemView.findViewById(R.id.date);
        image = (ImageView) itemView.findViewById(R.id.image);
        mcontent = itemView.findViewById(R.id.mcontent) ;
        section = itemView.findViewById(R.id.post_section);


       // webView = (WebView) itemView.findViewById(R.id.webView);




    }
}
