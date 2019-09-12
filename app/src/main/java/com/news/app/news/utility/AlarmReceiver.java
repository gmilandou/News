package com.news.app.news.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.news.app.news.controller.AdapterArticleSearch;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gmilandou on 09/02/2019.
 */

@SuppressWarnings("DefaultFileTemplate")
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);

        //Retriving the existing mood before adding new mood
        String searchText = preferences.getString("searchQuery", null);

        Log.d("Test", "Task successfully executed: " + searchText);


        ApiUtil.getServiceClass().getSavedSearch(searchText).enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArticleSearchResponse postList = response.body();
                    //AdapterArticleSearch adapter = new AdapterArticleSearch(getContext(), postList);
                    // recyclerView.setAdapter(adapter);

                    Log.d("Test", "I need to show the pop up right here ");
                }
            }

            @Override
            public void onFailure(Call<ArticleSearchResponse> call, Throwable t) {
                Log.d("TAG", "error loading from API");
            }
        });

    }
}