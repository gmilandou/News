package com.news.app.news.controller;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.news.app.news.R;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
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

        viewPager = findViewById(R.id.viewpagerSearch);
        ViewPagerAdapterSearch adapter = new ViewPagerAdapterSearch(getSupportFragmentManager(), intent);
        viewPager.setAdapter(adapter);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ArrayList<String> section = (ArrayList<String>) intent.getSerializableExtra("section");
        final String searchText = intent.getStringExtra("search_text");
        String begin_date = "20170101";
        String endDate = "20190807";
        String apiKey = "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk";


        ApiUtil.getServiceClass().getSearch(searchText, section, begin_date, endDate, apiKey).enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                }
            }


            @Override
            public void onFailure(Call<ArticleSearchResponse> call, Throwable t) {
                //Log.d(TAG, "error loading from API");
                Toast.makeText(SearchResultActivity.this, "No result found for this search criteria", Toast.LENGTH_SHORT).show();
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
