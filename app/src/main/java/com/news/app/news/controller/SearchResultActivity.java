package com.news.app.news.controller;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.news.app.news.view.SearchFragment;
import com.news.app.news.R;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.view.SearchFragment;
import com.news.app.news.view.ViewPagerAdapterSearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        //Intent intentBoxes = getIntent();

        viewPager = findViewById(R.id.viewpagerSearch);
        ViewPagerAdapterSearch adapter = new ViewPagerAdapterSearch(getSupportFragmentManager(), intent);
        viewPager.setAdapter(adapter);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ArrayList<String> section =(ArrayList<String>)intent.getSerializableExtra("section");

       // Toast.makeText(this, "Checking intent: " + intent.getStringExtra("search_text"), Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "Checking intent: " + intent.getStringExtra("section"), Toast.LENGTH_LONG).show();

        Toast.makeText(this, "Checking intent: " + section, Toast.LENGTH_LONG).show();


        //String searchText = "Obama";
        final String searchText = intent.getStringExtra("search_text");
       // String section = "Politics";
        String begin_date = "20170101";
        String apiKey = "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk";
        String endDate = "20190807";


        ApiUtil.getServiceClass().getSearch(searchText, section, begin_date, endDate, apiKey).enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArticleSearchResponse postList = response.body();
                    AdapterArticleSearch adapter = new AdapterArticleSearch(SearchResultActivity.this, postList);
//                    recyclerView.setAdapter(adapter);

                    Log.d("TAG", "This is the full response: " + searchText); //response.body().toString());
                }
            }


            @Override
            public void onFailure(Call<ArticleSearchResponse> call, Throwable t) {
                //Log.d(TAG, "error loading from API");
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


}
