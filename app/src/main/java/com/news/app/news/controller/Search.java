package com.news.app.news.controller;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.news.app.news.R;
import com.news.app.news.view.ArticleFragment;
import com.news.app.news.view.SearchFragment;

public class Search extends AppCompatActivity {

    public static EditText search_text;
    private CheckBox art_checkbox;
    private CheckBox politics_checkbox;
    private CheckBox business_checkbox;
    private CheckBox sport_checkbox;
    private CheckBox entrepreneur_checkbox;
    private CheckBox travel_checkbox;
    private Button search_button;
    private Switch switch_button;


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
                search_text.setHint("Search query term");
            } else {
                switch_button.setVisibility(View.GONE);
            }
        }


        Switch toggle = findViewById(R.id.switch_button);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast.makeText(Search.this, "SWITCH IS ENABLED", Toast.LENGTH_SHORT).show();
                } else {
                    // The toggle is disabled
                    Toast.makeText(Search.this, "SWITCH IS DISABLED", Toast.LENGTH_SHORT).show();
                }
            }
        });


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Search.this, SearchResultActivity.class);
                String t = search_text.getText().toString();
                intent.putExtra("search_text", t);
                //intent.putExtra("art_checkbox", art_checkbox.getText());
                //intent.putExtra("politics_checkbox", politics_checkbox.getText());
                //intent.putExtra("business_checkbox", business_checkbox.getText());
                //intent.putExtra("sport_checbox", sport_checkbox.getText());
                //intent.putExtra("entrepreneur_checkbox", entrepreneur_checkbox.getText());
                //intent.putExtra("travel_checkbox", travel_checkbox.getText());

                //String begin_date = "20170101";
                //String endDate = "20190807";
                intent.putExtra("begin_date", "20170101");
                intent.putExtra("endDate", "20190807");

                intent.putExtra("search_button", search_button.getText());

                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?


        //intent.putExtra("art_checkbox", art_checkbox.getText());
        //intent.putExtra("politics_checkbox", politics_checkbox.getText());
        //intent.putExtra("business_checkbox", business_checkbox.getText());
        //intent.putExtra("sport_checbox", sport_checkbox.getText());
        //intent.putExtra("entrepreneur_checkbox", entrepreneur_checkbox.getText());
        //intent.putExtra("travel_checkbox", travel_checkbox.getText());

        Intent intentBoxes = new Intent(Search.this, SearchResultActivity.class);
        String t = search_text.getText().toString();

        intentBoxes.putExtra("search_text", t);
        intentBoxes.putExtra("search_text", t);
        intentBoxes.putExtra("search_text", t);

        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.art_checkbox:
                if (checked) {
                    intentBoxes.putExtra("section", "Arts");
                }
                // Put some meat on the sandwich
                else
                    Toast.makeText(this, "Arts section did not work as expected ! ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.politic_checkbox:
                if (checked) {
                    intentBoxes.putExtra("section", "Politics");
                }

                else
                    Toast.makeText(this, "Politics section did not work as expected !", Toast.LENGTH_SHORT).show();
                    break;
                // TODO: Veggie sandwich

        }
        startActivity(intentBoxes);
    }

    public static String textSearch() {

        return search_text.getText().toString();
    }


}
