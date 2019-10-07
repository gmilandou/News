package com.news.app.news.utility;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.news.app.news.controller.AdapterArticleSearch;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.articlesearch.Doc;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.news.app.news.MainActivity.NOTIFICATION_CHANNEL_ID;

public class AlarmReceiver extends BroadcastReceiver {
    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";

    public void onReceive(final Context context, final Intent intent) {


        ////// Logic start
        SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        //Retriving the existing mood before adding new mood
        String searchText = preferences.getString("searchQuery", null);
        String section = preferences.getString("section", null);
        String[] arraySections = section.split(",");
        ArrayList<String> mySectionList = new ArrayList<>();
        for (String arraySection : arraySections) {
            mySectionList.add(arraySection);
        }
        ApiUtil.getServiceClass().getSearch(searchText, mySectionList, null, null, "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk").enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArticleSearchResponse postList = response.body();

                    Log.d("Test", "Web service successfully called: ");

                    //Log.d("Log printing", "onResponse: " + postList.getResponse().getDocs().get(0).getPubDate());
                    Log.d("Log printing", "onResponse: " + postList.getResponse().getDocs());

                    if(postList.getResponse().getDocs() == null || postList.getResponse().getDocs().isEmpty() ){
                        Log.d("Log printing", "onResponse: No Data found for the saved shared preference");
                    }else {

                        //Setting my notification
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                        Notification notification = intent.getParcelableExtra(NOTIFICATION);
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            int importance = NotificationManager.IMPORTANCE_HIGH;
                            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                            assert notificationManager != null;
                            notificationManager.createNotificationChannel(notificationChannel);
                        }
                        int id = intent.getIntExtra(NOTIFICATION_ID, 0);
                        assert notificationManager != null;
                        notificationManager.notify(id, notification);

                    }

                }
            }

            @Override
            public void onFailure(Call<ArticleSearchResponse> call, Throwable t) {
                Log.d("TAG", "error loading from API");
            }
        });
        /////// Logic end

    }

}
