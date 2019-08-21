package com.news.app.news.controller;

/**
 * Created by USER on 4/22/2019.
 */

import android.content.Intent;
import android.widget.Toast;

import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.mostpopular.MostPopularNYTResponse;
import com.news.app.news.model.topstories.NewYorkTimesResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

import static android.app.PendingIntent.getActivity;
import static android.content.Intent.getIntent;


public interface RetrofitInterface {

    String apiKey = "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk";
   // String endDate = "20190807";
   // String beginDate = "20170101";
    //String searchText = "Trump";
    //String searchText = Search.textSearch();
    //String news_desk = "Society";


    // @GET("svc/search/v2/articlesearch.json?fq={text} AND news_desk:(\"" + news_desk + "\") AND source:(\"The New York Times\") &facet_field=day_of_week&facet=true&begin_date=" + beginDate +
    //       "&end_date=" + endDate + "&api-key=" + apiKey)
    //Call<ArticleSearchResponse> getSearch(String s, @Query("text") String text);


    @GET("svc/topstories/v2/science.json?api-key=" + apiKey)
    Call<NewYorkTimesResponse> getTopStories();

    // @GET("svc/topstories/v2/science.json?api-key=")
    //Call<NewYorkTimesResponse> getTopStories(
    //      @Query("apiKey1") String apiKey1);

    @GET("svc/mostpopular/v2/emailed/7.json?api-key=" + apiKey)
    Call<MostPopularNYTResponse> getMostPopular();

    @GET("svc/search/v2/articlesearch.json?q=election&api-key=" + apiKey)
    Call<ArticleSearchResponse> getArticleSearch();


    @GET("svc/search/v2/articlesearch.json")
    Call<ArticleSearchResponse> getSearch(
            @Query("q") String searchText,
            @Query("fq") String section,
            @Query("begin_date") String begin_date,
            @Query("end_date") String endDate1,
            @Query("api-key") String apiKey1

    );


    // @GET("svc/search/v2/articlesearch.json?fq=" + news_desk + " AND news_desk:(\"" + news_desk + "\") AND source:(\"The New York Times\") &facet_field=day_of_week&facet=true&begin_date=" + beginDate +
    //       "&end_date=" + endDate + "&api-key=" + apiKey)
    //Call<ArticleSearchResponse> getSearch();


    //https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=Trump AND news_desk:("Arts")  AND source:("The New York Times")&facet_field=day_of_week&facet=true&begin_date=20170101&end_date=20190805&api-key=3zQ75lelXXmxuZpVMSLzaD06md8zaPhkIntent intent = getIntent();

}