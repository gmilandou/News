package com.news.app.news.controller;

/**
 * Created by USER on 4/22/2019.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.app.news.R;
import com.news.app.news.model.topstories.NewYorkTimesResponse;
import com.news.app.news.model.topstories.Results;
import com.news.app.news.view.activity_webview;
import com.squareup.picasso.Picasso;
import com.news.app.news.utility.Processor;

import java.text.ParseException;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;
    private NewYorkTimesResponse apiObjectList;
    private List<Results> apiObject;

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

        final Results results = apiObject.get(position);

        String ImageUrl = null;
        if (apiObject.get(position).getMultimedia().size() > 0) {
            ImageUrl = apiObject.get(position).getMultimedia().get(0).getUrl();
        }


        String UpdatedDate = results.getUpdated_date();
        //String SiteUrl = results.getUrl().toString();
        String section = results.getSection();

        try {
            FormattedDate = processor.dateFormatterA(UpdatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.description.setText(results.getTitle());
        holder.updated_date.setText(FormattedDate);
        holder.section.setText(section + " >");
        Picasso.get().load(ImageUrl)
                .placeholder(R.drawable.index).into(holder.image);

        holder.mcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, activity_webview.class);
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

