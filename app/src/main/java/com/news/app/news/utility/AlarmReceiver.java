package com.news.app.news.utility;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.news.app.news.BuildConfig;
import com.news.app.news.R;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.controller.SearchResultActivity;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.articlesearch.Doc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.news.app.news.MainActivity.NOTIFICATION_CHANNEL_ID;

public class AlarmReceiver extends BroadcastReceiver {
    //    public static String NOTIFICATION = "notification";
    private Context GlobalContext;
    private final static String default_notification_channel_id = "default";
    //String[] arraySections;
    private ArrayList<String> mySectionList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onReceive(final Context context, final Intent intent) {
        GlobalContext = context;

        SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        //Retriving the existing mood before adding new mood
        final String searchText = preferences.getString("searchQuery", null);
        String section = preferences.getString("section", null);
        //String[] arraySections = section.split(",");

        if (section != null) {
            String[] arraySections = section.split(",");

            mySectionList = new ArrayList<>(Arrays.asList(arraySections));
        }

        String apiKey = BuildConfig.GoogleSecAPIKEY;

        String todayDate = LocalDateTime.now().toString();

        ApiUtil.getServiceClass().getSearch(searchText, mySectionList, todayDate, todayDate, apiKey).enqueue(new Callback<ArticleSearchResponse>() {
            //good one

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<ArticleSearchResponse> call, @NonNull Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArticleSearchResponse postList = response.body();

                    if (Objects.requireNonNull(postList).getResponse().getDocs() == null || postList.getResponse().getDocs().isEmpty()) {
                        Log.d("Log printing", "onResponse: No Data found for the saved shared preference");
                    } else {

                        //Setting my notification
                        getNotification((ArrayList<Doc>) postList.getResponse().getDocs());

                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<ArticleSearchResponse> call, @NonNull Throwable t) {
                Log.d("TAG", "error loading from API");
                Toast.makeText(context, "Error while loading data, please check your Internet connection ! ", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getNotification(ArrayList<Doc> postList) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(GlobalContext, default_notification_channel_id);

        NotificationManager notificationManager = (NotificationManager) GlobalContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
        }


        Intent notificationIntent = new Intent(GlobalContext, SearchResultActivity.class);
        notificationIntent.putExtra("NotificationMessage", "I am from Notification");
        notificationIntent.putParcelableArrayListExtra("ListObject", postList);
        PendingIntent pendingIntent = PendingIntent.getActivity(GlobalContext, 0, notificationIntent, 0);

        builder.setContentIntent(pendingIntent);

        builder.setContentTitle("My News App");
        builder.setSmallIcon(R.drawable.ic_action_name);
        builder.setContentText("Hello Buddy,  There are some news that match your daily stored search criteria, check them out !");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setAutoCancel(true);
        builder.setChannelId(NOTIFICATION_CHANNEL_ID);
        builder.setDefaults(Notification.DEFAULT_SOUND);

        Notification notification = builder.build();
        assert notificationManager != null;
        notificationManager.notify(1, notification);
    }

}
