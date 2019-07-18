package com.news.app.news.controller;

/**
 * Created by USER on 4/22/2019.
 */

import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.mostpopular.MostPopularNYTResponse;
import com.news.app.news.model.topstories.NewYorkTimesResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetrofitInterface {

    @GET("svc/topstories/v2/science.json?api-key=3zQ75lelXXmxuZpVMSLzaD06md8zaPhk")
    public Call<NewYorkTimesResponse> getTopStories();

    @GET("svc/mostpopular/v2/emailed/7.json?api-key=3zQ75lelXXmxuZpVMSLzaD06md8zaPhk")
    public Call<MostPopularNYTResponse> getMostPopular();

    @GET("svc/search/v2/articlesearch.json?q=election&api-key=3zQ75lelXXmxuZpVMSLzaD06md8zaPhk")
    public Call<ArticleSearchResponse> getArticleSearch();

}