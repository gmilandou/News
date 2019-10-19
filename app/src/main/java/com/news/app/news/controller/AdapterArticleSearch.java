package com.news.app.news.controller;

/*
  Created by USER on 4/22/2019.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.app.news.R;
import com.news.app.news.model.articlesearch.Doc;
import com.news.app.news.utility.Processor;
import com.news.app.news.view.ActivityWebview;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class AdapterArticleSearch extends RecyclerView.Adapter<NewsViewHolder> {

    private final Context context;
    private final List<Doc> apiObject;

    public AdapterArticleSearch(Context context, ArrayList<Doc> apiObjects) {
        this.context = context;
        apiObject = apiObjects;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new NewsViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {

        String formattedDate = null;
        Processor processor = new Processor();
        Doc doc = apiObject.get(position);

        String imageUrl = null;
        if (apiObject.get(position).getMultimedia() != null && apiObject.get(position).getMultimedia().size() > 0) {
            imageUrl = "https://static01.nyt.com/" + apiObject.get(position).getMultimedia().get(0).getUrl();
        }

        String brief = doc.getSnippet();
        holder.description.setText(brief);
        String updatedDate = doc.getPubDate();
        String section = doc.getSectionName();

        Picasso.get().load(imageUrl)
                .placeholder(R.drawable.index).into(holder.image);

        try {
            formattedDate = processor.dateFormatterA(updatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.updated_date.setText(formattedDate);
        holder.section.setText(section + " >");
        holder.mcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ActivityWebview.class);
                intent.putExtra("WEBURL", apiObject.get(position).getWebUrl());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {

        return apiObject.size();

    }

}

