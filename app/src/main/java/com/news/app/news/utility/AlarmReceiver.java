package com.news.app.news.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.news.app.news.MainActivity;
import com.news.app.news.controller.AdapterArticleSearch;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String section = preferences.getString("section", null);

      //  ArrayList<String> mySectionList = new ArrayList<>(Arrays.asList(section.split(",")));
       String[] arraySections =  section.split(",");
       ArrayList<String> mySectionList = new ArrayList<>();

        for (String arraySection : arraySections) {
            mySectionList.add(arraySection);
        }

        // List<String> sectionList = Arrays.asList(section.split(","));

        Log.d("Test", "Task successfully executed: " + searchText + " & " + mySectionList);


        ApiUtil.getServiceClass().getSearch(searchText, mySectionList, "", "", "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk").enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArticleSearchResponse postList = response.body();
                    //AdapterArticleSearch adapter = new AdapterArticleSearch(getContext(), postList);
                    // recyclerView.setAdapter(adapter);
                    Log.d("Test", "Task successfully executed: ");


                } else {
                    Log.d("Test", "Sorry i could not get any data");
                }
            }

            @Override
            public void onFailure(Call<ArticleSearchResponse> call, Throwable t) {
                Log.d("TAG", "error loading from API");
            }
        });

    }

    private int trackRetrofitCall() {
        int data = Log.d("Test", "This is just to check if my retrofit call is working !!");
        return data;
    }
}