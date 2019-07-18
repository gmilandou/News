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
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.articlesearch.Doc;
import com.news.app.news.model.articlesearch.Response;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.topstories.Results;
import com.news.app.news.utility.Processor;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

//import com.news.app.news.model.mostpopular.Multimedia;


public class AdapterArticleSearch extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;

    private ArticleSearchResponse apiObject;
    //private List<Doc> apiObject;


    public AdapterArticleSearch(Context context, ArticleSearchResponse apiObjects) {
        this.context = context;
        this.apiObject = apiObjects;
        //apiObject = apiObjectList.getDocs();

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


        this.apiObject.getResponse().getDocs().get(0).getWebUrl();
        String ImageUrl = "https://static01.nyt.com/" + this.apiObject.getResponse().getDocs().get(0).getMultimedia().get(0).getUrl();
        String brief = this.apiObject.getResponse().getDocs().get(0).getLeadParagraph();
        holder.description.setText(brief);
        String UpdatedDate = this.apiObject.getResponse().getDocs().get(0).getPubDate().toString();
        Picasso.get().load(ImageUrl).into(holder.image);

        try {
            FormattedDate = processor.dateFormatterA(UpdatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.updated_date.setText(FormattedDate);


    }


    @Override
    public int getItemCount() {

        // if(apiObject == null || apiObject.getResponse().getDocs().isEmpty() || apiObject.getResponse().getDocs().size() ==0){
        //   return 0;
        //}

        //return apiObject.size();
        return apiObject.getResponse().getDocs().size();
    }

}

