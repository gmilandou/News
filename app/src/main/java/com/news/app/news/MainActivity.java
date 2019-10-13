package com.news.app.news;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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
import com.news.app.news.controller.SearchResultActivity;
import com.news.app.news.utility.AlarmReceiver;
import com.news.app.news.view.ViewPagerAdapter;

import java.util.Calendar;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static final String NOTIFICATION_CHANNEL_ID = "10001";
   // private final static String default_notification_channel_id = "default";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        scheduleNotification();
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


    /*@Override
    protected void onNewIntent (Intent intent) {
        super .onNewIntent(intent) ;
        Bundle extras = intent.getExtras() ;
        if (extras != null ) {
            if (extras.containsKey( "NotificationMessage" )) {
                String msg = extras.getString( "NotificationMessage" ) ;
                //TextView tvNotify = findViewById(R.id. tvNotify ) ;
                //tvNotify.setText(msg) ;

                //creating and initializing an Intent object
                Intent intent1 = new Intent(this, SearchResultActivity.class);
                //attach the key value pair using putExtra to this intent
                String user_name = "Jhon Doe";
                intent.putExtra("USER_NAME", user_name);
                //starting the activity
                startActivity(intent1);
            }
        }
    }*/

    private void scheduleNotification() {
        //Intent notificationIntent = new Intent(this, AlarmReceiver.class);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        //notificationIntent.putExtra(AlarmReceiver.NOTIFICATION, notification);
      /* notificationIntent.putExtra(AlarmReceiver.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(AlarmReceiver.NOTIFICATION, notification);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
*/



        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // long futureInMillis = SystemClock.elapsedRealtime() + delay;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, 59);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }


    /*private Notification getNotification(String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, default_notification_channel_id);

        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.journaldev.com/"));
        //PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        //builder.setContentIntent(pendingIntent);

        Intent notificationIntent = new Intent(MainActivity. this, SearchResultActivity.class ) ;
        notificationIntent.putExtra( "NotificationMessage" , "I am from Notification" ) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        builder.setContentIntent(pendingIntent);

        builder.setContentTitle("My News App");
        builder.setSmallIcon(R.drawable.ic_action_name);
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setAutoCancel(true);
        builder.setChannelId(NOTIFICATION_CHANNEL_ID);
        builder.setDefaults(Notification.DEFAULT_SOUND);

        return builder.build();
    }
    */


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
