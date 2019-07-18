package com.news.app.news.controller;

/**
 * Created by USER on 4/22/2019.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.app.news.R;
import com.news.app.news.model.mostpopular.MostPopularNYTResponse;
import com.news.app.news.model.mostpopular.Multimedia;
import com.news.app.news.model.mostpopular.ResultSearch;
import com.news.app.news.utility.Processor;
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

        ResultSearch results = apiObject.get(position);
        String ImageUrl = apiObject.get(position).getMedia().get(0).getMediaMetadata().get(0).getUrl();
        String UpdatedDate = results.getUpdated();

        try {
          FormattedDate = processor.dateFormatterB(UpdatedDate);
       } catch (ParseException e) {
          e.printStackTrace();
       }

        holder.description.setText(results.getTitle());
        holder.updated_date.setText(FormattedDate);
        Picasso.get().load(ImageUrl).into(holder.image);
    }


    @Override
    public int getItemCount() {

        if(apiObject.isEmpty() || apiObject == null || apiObject.size() ==0){
            return 0;
        }

        return apiObject.size();
    }

}

