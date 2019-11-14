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
import com.news.app.news.model.mostpopular.MostPopularNYTResponse;
import com.news.app.news.model.mostpopular.ResultSearch;
import com.news.app.news.utility.Processor;
import com.news.app.news.view.ActivityWebview;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.List;


public class AdapterMostPopular extends RecyclerView.Adapter<NewsViewHolder> {

    private final Context context;


    private final List<ResultSearch> apiObject;

    public AdapterMostPopular(Context context, MostPopularNYTResponse apiObjects) {
        this.context = context;
        apiObject = apiObjects.getResultSearch();
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
        final ResultSearch results = apiObject.get(position);
        String imageUrl = null;
        if (apiObject.get(position).getMedia().get(0).getMediaMetadata().size() > 0) {
            imageUrl = apiObject.get(position).getMedia().get(0).getMediaMetadata().get(0).getUrl();
        }

        String updatedDate = results.getUpdated();
        String section = results.getSection();

        try {
            formattedDate = processor.dateFormatterB(updatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Fetching article description
        holder.description.setText(results.getTitle());

        //Fetching article date
        holder.updatedDate.setText(formattedDate);

        //Fetching article section
        holder.section.setText(section + " >");

        //Fetching image resource
        Picasso.get().load(imageUrl)
                .placeholder(R.drawable.index).into(holder.image);

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

        return apiObject.size();
    }

}

