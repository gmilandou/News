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
import com.news.app.news.model.topstories.NewYorkTimesResponse;
import com.news.app.news.model.topstories.Results;
import com.news.app.news.view.ActivityWebview;
import com.squareup.picasso.Picasso;
import com.news.app.news.utility.Processor;

import java.text.ParseException;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<NewsViewHolder> {

    private final Context context;
    private final List<Results> apiObject;

    public Adapter(Context context, NewYorkTimesResponse apiObjects) {
        this.context = context;
        apiObject = apiObjects.getResults();
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new NewsViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        String formattedDate = null;

        Processor processor = new Processor();

        final Results results = apiObject.get(position);

        //Fetching image resource
        String imageUrl = null;
        if (apiObject.get(position).getMultimedia().size() > 0) {
            imageUrl = apiObject.get(position).getMultimedia().get(0).getUrl();
        }

        //Fetching Date and section
        String updatedDate = results.getUpdated_date();
        String section = results.getSection();

        try {
            formattedDate = processor.dateFormatterA(updatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.description.setText(results.getTitle());
        holder.updatedDate.setText(formattedDate);
        holder.section.setText(section + " >");
        Picasso.get().load(imageUrl)
                .placeholder(R.drawable.logo).into(holder.image);

        //Setting up the Webview lick listener
        holder.mContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ActivityWebview.class);
                intent.putExtra("WEBURL", results.getUrl());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (apiObject == null || apiObject.size() == 0) {
            return 0;
        }

        return apiObject.size();

    }


}

