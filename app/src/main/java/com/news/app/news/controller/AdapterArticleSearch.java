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
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.articlesearch.Doc;
import com.news.app.news.utility.Processor;
import com.news.app.news.view.activity_webview;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class AdapterArticleSearch extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;
    private ArrayList<Doc> apiObjectList;
    private List<Doc> apiObject;

    public AdapterArticleSearch(Context context, ArrayList<Doc> apiObjects) {
        this.context = context;
        this.apiObjectList = apiObjects;
        apiObject = apiObjectList;
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new NewsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {

        String FormattedDate = null;
        Processor processor = new Processor();
        Doc doc = apiObject.get(position);

        String ImageUrl = null;
        if (apiObject.get(position).getMultimedia() != null && apiObject.get(position).getMultimedia().size() > 0) {
            ImageUrl = "https://static01.nyt.com/" + apiObject.get(position).getMultimedia().get(0).getUrl();
        }

        String brief = doc.getSnippet();
        holder.description.setText(brief);
        String UpdatedDate = doc.getPubDate();
        String section = doc.getSectionName();

        Picasso.get().load(ImageUrl)
                .placeholder(R.drawable.index).into(holder.image);

        try {
            FormattedDate = processor.dateFormatterA(UpdatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.updated_date.setText(FormattedDate);
        holder.section.setText(section + " >");
        holder.mcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, activity_webview.class);
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

