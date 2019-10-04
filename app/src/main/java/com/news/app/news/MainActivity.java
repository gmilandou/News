package com.news.app.news;


import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.news.app.news.controller.SearchActivity;
import com.news.app.news.utility.AlarmReceiver;
import com.news.app.news.view.ViewPagerAdapter;

import java.net.URISyntaxException;
import java.util.Calendar;


@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAlarmManager();


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        //initSearchCriteriaStrg();


    }

    /*public void notification(){

        try {
            sendNotification("This is a test", "Gildas", Intent.getIntent(Context.NOTIFICATION_SERVICE), 2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }*/


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
            Toast.makeText(this, "This is Help", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "This is About", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.search) {
            Intent i = new Intent(MainActivity.this, SearchActivity.class);
            i.putExtra("Notification_type", "SearchActivity");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public void sendNotification(String message, String title, Intent intent, int not_id) {


        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notification;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            notification
                    = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                    .setContentTitle(title)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentText(message)
                    //.setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

        } else {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            notification
                    = new NotificationCompat.Builder(this)
                    .setContentTitle(title)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                    .setContentText(message)
                    //.setAutoCancel(true)
                    .setColor(Color.parseColor("#1a4994"))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setLargeIcon(bitmap)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

        }

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(not_id, notification.build());


    }

    //Initialising searchCriteriaStorage
    private void initSearchCriteriaStrg() {
        initAlarmManager();
    }

    private void initAlarmManager() {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        Calendar calendar = Calendar.getInstance();
        //calendar.set(Calendar.HOUR_OF_DAY, 19);
        //calendar.set(Calendar.MINUTE, 57);
        //calendar.set(Calendar.SECOND, 0);

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, 59);

        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmPendingIntent);

        }
    }

    /*private void displaySelectedScreen(int id) {
        Fragment fragment = null;

        switch (id) {
            case R.id.section1:
                fragment = new sectionOne();
                break;
            case R.id.section2:
                fragment = new section2();
                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        displaySelectedScreen(id);
        return true;
    }
    */

}
