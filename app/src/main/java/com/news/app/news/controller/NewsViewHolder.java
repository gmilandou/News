package com.news.app.news.controller;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.news.app.news.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    final TextView description;
    final TextView updatedDate;
    final ImageView image;
    final LinearLayout mContent;
    public final TextView section;


    NewsViewHolder(View itemView) {
        super(itemView);

        description = itemView.findViewById(R.id.post_description);
        updatedDate = itemView.findViewById(R.id.date);
        image = itemView.findViewById(R.id.image);
        mContent = itemView.findViewById(R.id.mcontent);
        section = itemView.findViewById(R.id.post_section);

    }
}
