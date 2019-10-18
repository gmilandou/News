package com.news.app.news;

/**
 * Created by USER on 4/22/2019.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView description;

    public NewsViewHolder(View itemView) {
        super(itemView);
        // title = (TextView) itemView.findViewById(R.id.post_title);
        description = itemView.findViewById(R.id.post_description);
    }
}