package com.news.app.news.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.news.app.news.R;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    private EditText search_text;
    private CheckBox artCheckbox;
    private CheckBox politicsCheckbox;
    private CheckBox businessCheckbox;
    private CheckBox sportCheckbox;
    private CheckBox entrepreneurCheckbox;
    private CheckBox travelCheckbox;
    private String globalBeginDate;
    private String globalEndDate = "";
    private final ArrayList<String> sectionList = new ArrayList<>();

    public SearchActivity() {
        globalBeginDate = "";
    }

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
        artCheckbox = findViewById(R.id.art_checkbox);
        politicsCheckbox = findViewById(R.id.politic_checkbox);
        businessCheckbox = findViewById(R.id.business_checkbox);
        sportCheckbox = findViewById(R.id.sport_checkbox);
        entrepreneurCheckbox = findViewById(R.id.entre_checkbox);
        travelCheckbox = findViewById(R.id.travel_checkbox);
        Button searchButton = findViewById(R.id.searchButton);
        Switch switchButton = findViewById(R.id.switch_button);

        String notif = notificationType.getStringExtra("Notification_type");
        if (notif != null) {

            if (notif.equalsIgnoreCase("Notification")) {
                findViewById(R.id.date_layout).setVisibility(View.GONE);
                searchButton.setVisibility(View.GONE);
                toolbar.setTitle("Notification");

            } else {
                switchButton.setVisibility(View.GONE);
                toolbar.setTitle("Search Articles");
            }


            SharedPreferences preferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);//getPreferences(MODE_PRIVATE);
            String storedSearchQueryTerm = preferences.getString("searchQuery", null);

            if (storedSearchQueryTerm != null && !storedSearchQueryTerm.isEmpty()) {
                //search_text.setHint(storedSearchQueryTerm);
                search_text.setText(storedSearchQueryTerm);
            } else {
                search_text.setHint("Search query term");
            }
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
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

                if (artCheckbox.isChecked()) {
                    sectionList.add("Arts");
                }
                if (politicsCheckbox.isChecked()) {
                    sectionList.add("Politics");
                }
                if (businessCheckbox.isChecked()) {
                    sectionList.add("Business");
                }
                if (sportCheckbox.isChecked()) {
                    sectionList.add("Sports");
                }
                if (entrepreneurCheckbox.isChecked()) {
                    sectionList.add("Entrepreneurs");
                }
                if (travelCheckbox.isChecked()) {
                    sectionList.add("Travels");
                    Toast.makeText(SearchActivity.this, "Travel selected", Toast.LENGTH_SHORT).show();
                }
                intent.putStringArrayListExtra("section", sectionList);
                // Log.d("test", "testing: " + sectionList);
                startActivity(intent);
            }
        });

        @SuppressLint("CutPasteId") Switch toggle = findViewById(R.id.switch_button);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    String mySection = "";
                    String mySection1;
                    String mySection2;
                    String mySection3;
                    String mySection4;
                    String mySection5;
                    String mySection6;

                    if (artCheckbox.isChecked()) {
                        mySection1 = "Arts";
                        mySection += mySection1 + ",";
                    }
                    if (politicsCheckbox.isChecked()) {
                        mySection2 = "Politics";
                        mySection += mySection2 + ",";
                    }
                    if (businessCheckbox.isChecked()) {
                        mySection3 = "Business";
                        mySection += mySection3 + ",";
                    }
                    if (sportCheckbox.isChecked()) {
                        mySection4 = "Sports";
                        mySection += mySection4 + ",";
                    }
                    if (entrepreneurCheckbox.isChecked()) {
                        mySection5 = "Entrepreneurs";
                        mySection += mySection5 + ",";
                    }
                    if (travelCheckbox.isChecked()) {
                        mySection6 = "Travels";
                        mySection += mySection6;
                    }

                    Toast.makeText(SearchActivity.this, "Search query term successfully saved ! ", Toast.LENGTH_LONG).show();

                    SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    String searchQuery = search_text.getText().toString();
                    edit.putString("searchQuery", searchQuery);
                    edit.putString("section", mySection);
                    edit.apply();
                } else {
                    // The toggle is disabled
                    Toast.makeText(SearchActivity.this, "Search query term has been disabled", Toast.LENGTH_LONG).show();
                    //Insertion of Mood using shared preferences
                    SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);//getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    String searchQuery = "";
                    String mySection = "";
                    editor.putString("searchQuery", searchQuery);
                    editor.putString("section", mySection);
                    editor.apply();
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


