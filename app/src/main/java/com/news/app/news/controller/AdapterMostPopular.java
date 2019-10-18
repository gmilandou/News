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
import com.news.app.news.model.mostpopular.MostPopularNYTResponse;
import com.news.app.news.model.mostpopular.Multimedia;
import com.news.app.news.model.mostpopular.ResultSearch;
import com.news.app.news.utility.Processor;
import com.news.app.news.view.ActivityWebview;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public class AdapterMostPopular extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;


    private MostPopularNYTResponse apiObjectList;
    private List<ResultSearch> apiObject;
    private Date updated_date;
    private Multimedia media;


    public AdapterMostPopular(Context context, MostPopularNYTResponse apiObjects) {
        this.context = context;
        this.apiObjectList = apiObjects;
        apiObject = apiObjectList.getResultSearch();
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
        final ResultSearch results = apiObject.get(position);
        String ImageUrl = null;
        if (apiObject.get(position).getMedia().get(0).getMediaMetadata().size() > 0) {
            ImageUrl = apiObject.get(position).getMedia().get(0).getMediaMetadata().get(0).getUrl();
        }

        String UpdatedDate = results.getUpdated();
        String section = results.getSection();

        try {
            FormattedDate = processor.dateFormatterB(UpdatedDate);
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

