package com.news.app.news.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by gmilandou on 09/02/2019.
 */

@SuppressWarnings("DefaultFileTemplate")
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);

        //Retriving the existing mood before adding new mood
        String searchtext = preferences.getString("searchQuery", null);

        Log.d("Test", "Task successfully executed: " + searchtext);

    }
}