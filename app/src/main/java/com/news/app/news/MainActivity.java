package com.news.app.news;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.news.app.news.controller.SearchActivity;
import com.news.app.news.utility.AlarmReceiver;
import com.news.app.news.view.ViewPagerAdapter;

import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public static final String NOTIFICATION_CHANNEL_ID = "10001";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


     /*   if (userConnected()){
            Log.d("TUE", "You are connected");
            Toast.makeText(this, "You are connected to the Internet", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "You do not have Internet connection", Toast.LENGTH_LONG).show();
            Log.d("FALSE", "You are not connected");

        }
*/

        /// Check for bolean before calling this method below.
        SharedPreferences preferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        String notificationChecked = preferences.getString("notificationChecked", null);
        if (notificationChecked != null && notificationChecked.equalsIgnoreCase("true")) {
            scheduleNotification();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_notification) {
            Intent i = new Intent(MainActivity.this, SearchActivity.class);
            i.putExtra("Notification_type", "Notification");
            startActivity(i);
        } else if (id == R.id.action_help) {
            Toast.makeText(this, "Contact us at : gmilandou2012@gmail.com", Toast.LENGTH_LONG).show();
        }/* else if (id == R.id.action_about) {
            Toast.makeText(this, "This is About", Toast.LENGTH_SHORT).show();
        } */else if (id == R.id.search) {
            Intent i = new Intent(MainActivity.this, SearchActivity.class);
            i.putExtra("Notification_type", "SearchActivity");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    private void scheduleNotification() {
        Intent notificationIntent = new Intent(this, AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // long futureInMillis = SystemClock.elapsedRealtime() + delay;
        Calendar calendar = Calendar.getInstance();
      //  calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
       // calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
      //  calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);


        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }

   /* private boolean userConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }*/

}
