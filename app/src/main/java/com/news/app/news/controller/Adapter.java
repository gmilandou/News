package com.news.app.news.controller;

/**
 * Created by USER on 4/22/2019.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.app.news.R;
import com.news.app.news.model.topstories.Multimedia;
import com.news.app.news.model.topstories.NewYorkTimesResponse;
import com.news.app.news.model.topstories.Results;
import com.squareup.picasso.Picasso;
import com.news.app.news.utility.Processor;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;


    private NewYorkTimesResponse apiObjectList;
    private List<Results> apiObject;
    //private Date updated_date;
    //private Multimedia media;



    public Adapter(Context context, NewYorkTimesResponse apiObjects) {
        this.context = context;
        this.apiObjectList = apiObjects;
        apiObject = apiObjectList.getResults();
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new NewsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        String FormattedDate = null;

        Processor processor = new Processor();

        Results results = apiObject.get(position);
        String ImageUrl = apiObject.get(position).getMultimedia().get(0).getUrl();
        String UpdatedDate = results.getUpdated_date().toString();
        String SiteUrl = results.getUrl().toString();

        try {
           FormattedDate = processor.dateFormatter(UpdatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.description.setText(results.getTitle());
        holder.updated_date.setText(FormattedDate);
        Picasso.get().load(ImageUrl).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return apiObject.size();
    }

}

