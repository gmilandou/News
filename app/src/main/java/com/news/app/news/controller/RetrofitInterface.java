package com.news.app.news.controller;

/*
 Created by USER on 4/22/2019.
 */


import com.news.app.news.BuildConfig;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.mostpopular.MostPopularNYTResponse;
import com.news.app.news.model.topstories.NewYorkTimesResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetrofitInterface {

    String apiKey = BuildConfig.GoogleSecAPIKEY;


    @GET("svc/topstories/v2/science.json?api-key=" + apiKey)
    Call<NewYorkTimesResponse> getTopStories();

    @GET("svc/mostpopular/v2/emailed/7.json?api-key=" + apiKey)
    Call<MostPopularNYTResponse> getMostPopular();

    @GET("svc/search/v2/articlesearch.json?q=election&api-key=" + apiKey)
    Call<ArticleSearchResponse> getArticleSearch();


    @GET("svc/search/v2/articlesearch.json")
    Call<ArticleSearchResponse> getSearch(
            @Query("q") String searchText,
            @Query("fq") ArrayList<String> section,
            @Query("begin_date") String begin_date,
            @Query("end_date") String endDate,
            @Query("api-key") String apiKey
    );

}