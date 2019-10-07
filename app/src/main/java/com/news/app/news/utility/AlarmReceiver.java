package com.news.app.news.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.news.app.news.MainActivity;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;

import java.net.URISyntaxException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.parseUri;

/**
 * Created by gmilandou on 09/02/2019.
 */

@SuppressWarnings("DefaultFileTemplate")
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);


        //Retriving the existing mood before adding new mood
        String searchText = preferences.getString("searchQuery", null);
        String section = preferences.getString("section", null);

        //  ArrayList<String> mySectionList = new ArrayList<>(Arrays.asList(section.split(",")));
        String[] arraySections = section.split(",");
        ArrayList<String> mySectionList = new ArrayList<>();

        for (String arraySection : arraySections) {
            mySectionList.add(arraySection);
        }

        // ArrayList<String> sectiont = intent.getStringArrayListExtra("section");
        // List<String> sectionList = Arrays.asList(section.split(","));
        //Log.d("Test", "Task successfully executed: " + searchText + " & " + mySectionList);

        ApiUtil.getServiceClass().getSearch(searchText, mySectionList, null, null, "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk").enqueue(new Callback<ArticleSearchResponse>() {
            //  .....getSearch(searchText, mySectionList, null, null, "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk")....

            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArticleSearchResponse postList = response.body();
                    //AdapterArticleSearch adapter = new AdapterArticleSearch(getContext(), postList);
                    // recyclerView.setAdapter(adapter);
                    Log.d("Test", "Web service successfully called: ");

                    notification();

                    //Calling the method inside the main activity for the popup
                   // MainActivity mainActivity = new MainActivity();
                    //mainActivity.notification();

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

    public void notification(){
        MainActivity mainActivity = new MainActivity();
        try {
            mainActivity.sendNotification("This is a test", "Gildas", parseUri(Context.NOTIFICATION_SERVICE, 0), 2);
            //mainActivity.sendNotification("This is a test", "Gildas", Intent.getIntent(MainActivity.NOTIFICATION_SERVICE), 2);
            //sendNotification("This is a test", "Gildas", parseUri(Context.NOTIFICATION_SERVICE, 0), 2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }




}