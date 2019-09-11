package com.news.app.news.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.news.app.news.R;
import com.news.app.news.view.SearchResulsFragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static android.content.Context.MODE_PRIVATE;

public class SearchActivity extends AppCompatActivity {

    public static EditText search_text;
    private CheckBox art_checkbox;
    private CheckBox politics_checkbox;
    private CheckBox business_checkbox;
    private CheckBox sport_checkbox;
    private CheckBox entrepreneur_checkbox;
    private CheckBox travel_checkbox;
    private Button search_button;
    private Switch switch_button;
    String globalBeginDate = "";
    String globalEndDate = "";
    ArrayList<String> sectionList = new ArrayList<>();
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        Intent notificationType = getIntent();

        search_text = findViewById(R.id.searchText);
        art_checkbox = findViewById(R.id.art_checkbox);
        politics_checkbox = findViewById(R.id.politic_checkbox);
        business_checkbox = findViewById(R.id.business_checkbox);
        sport_checkbox = findViewById(R.id.sport_checkbox);
        entrepreneur_checkbox = findViewById(R.id.entre_checkbox);
        travel_checkbox = findViewById(R.id.travel_checkbox);
        search_button = findViewById(R.id.button);
        switch_button = findViewById(R.id.switch_button);

        String notif = notificationType.getStringExtra("Notification_type");
        if (notif != null) {

            if (notif.equalsIgnoreCase("Notification")) {
                findViewById(R.id.date_layout).setVisibility(View.GONE);
                search_button.setVisibility(View.GONE);

            } else {
                switch_button.setVisibility(View.GONE);
            }


            SharedPreferences preferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);//getPreferences(MODE_PRIVATE);
            String storedSearchQueryTerm = preferences.getString("searchQuery", null);

            if(storedSearchQueryTerm != null & !storedSearchQueryTerm.isEmpty()) {
                //search_text.setHint(storedSearchQueryTerm);
                search_text.setText(storedSearchQueryTerm);
            }else{
                search_text.setHint("Search query term");
            }
        }


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);


                String searchText = search_text.getText().toString();
                intent.putExtra("search_text", searchText);

                if (globalBeginDate.isEmpty()) {
                    globalBeginDate = "20180911";
                }

                if (globalEndDate.isEmpty()) {
                    globalEndDate = "20190911";
                }

                intent.putExtra("begin_date", globalBeginDate);
                intent.putExtra("endDate", globalEndDate);

                // ArrayList<String> sectionList = new ArrayList<>();

                if (art_checkbox.isChecked()) {
                    sectionList.add("Arts");
                }

                if (politics_checkbox.isChecked()) {
                    sectionList.add("Politics");
                }

                if (business_checkbox.isChecked()) {
                    sectionList.add("Business");
                }

                if (sport_checkbox.isChecked()) {
                    sectionList.add("Sports");
                }

                if (entrepreneur_checkbox.isChecked()) {
                    sectionList.add("Entrepreneurs");
                }

                if (travel_checkbox.isChecked()) {
                    sectionList.add("Travels");
                    Toast.makeText(SearchActivity.this, "Travel selected", Toast.LENGTH_SHORT).show();
                }

                intent.putStringArrayListExtra("section", sectionList);

                Log.d("test", "testing: " + sectionList);
                startActivity(intent);

            }
        });

        Switch toggle = findViewById(R.id.switch_button);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {

                    if (art_checkbox.isChecked()) {
                        sectionList.add("Arts");
                    }

                    if (politics_checkbox.isChecked()) {
                        sectionList.add("Politics");
                    }

                    if (business_checkbox.isChecked()) {
                        sectionList.add("Business");
                    }

                    if (sport_checkbox.isChecked()) {
                        sectionList.add("Sports");
                    }

                    if (entrepreneur_checkbox.isChecked()) {
                        sectionList.add("Entrepreneurs");
                    }

                    if (travel_checkbox.isChecked()) {
                        sectionList.add("Travels");
                    }

                    //SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);

                    //Retriving the existing mood before adding new mood
                  //  String searchtext = preferences.getString("searchQuery", null);

                    // The toggle is enabled
                    Toast.makeText(SearchActivity.this, "Search query term successfully saved ! " , Toast.LENGTH_LONG).show();

                    /*SharedPreferences prefs= SearchActivity.getApplicationContext().getSharedPreferences("yourPrefsKey", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit=prefs.edit();

                    Set<String> set = new HashSet<String>();
                    set.addAll(sectionList);
                    edit.putStringSet("yourKey", set);
                    edit.commit();*/

                    SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor edit=sharedPreferences.edit();

                    //Set<String> set = new HashSet<>();
                    //set.addAll(sectionList);
                    //edit.putStringSet("yourKey", set);
                    //edit.commit();


                    String searchQuery = search_text.getText().toString();
                    //ArrayList<String> section = sectionList;

                    edit.putString("searchQuery", searchQuery);
                   // editor.putStringSet("section", (Set<String>) section);
                    edit.apply();
                    //Log.d("Test", "I am here for the stored preferences: " + searchQuery + " & " + section);


                    //Insertion of Mood using shared preferences

                   // SharedPreferences.Editor editor = preferences.edit();

                    //editor.putString("searchQuery", searchQuery);
                    //editor.putInt("mMood1Color", newColor);
                   // editor.apply();

                } else {
                    // The toggle is disabled
                    Toast.makeText(SearchActivity.this, "Search query term has been disabled", Toast.LENGTH_LONG).show();

                    //Insertion of Mood using shared preferences
                    SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);//getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    String searchQuery = "";
                    //String section = "";

                    editor.putString("searchQuery", searchQuery);
                    //editor.putString("section", section);
                    editor.apply();

                    //Log.d("Test", "I am here for the stored preferences: " + section + " & " + section);



                }
            }
        });

    }


    public void showDatePicker(View v) {
        DialogFragment newFragment = new MyDatePickerFragment();

        if (v.getId() == R.id.begin_date) {

            Bundle myBundle = new Bundle();
            myBundle.putString("BundleTest", "beginDate");

            newFragment.setArguments(myBundle);
        } else {

            Bundle myBundle = new Bundle();
            myBundle.putString("BundleTest", "endDate");

            newFragment.setArguments(myBundle);
        }

        newFragment.show(getSupportFragmentManager(), "date picker");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void sendBeginDateValue(String beginDateValue) {

        TextView beginDate = findViewById(R.id.begin_date);

        beginDate.setText(beginDateValue);

        globalBeginDate = beginDateValue;

    }

    public void sendEndDateValue(String endDateValue) {

        TextView endDate = findViewById(R.id.end_date);

        endDate.setText(endDateValue);

        globalEndDate = endDateValue;

    }

}


