package com.news.app.news.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.news.app.news.R;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.articlesearch.Doc;
import com.news.app.news.utility.Processor;

import java.text.ParseException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
   // private ViewPager viewPager;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        //  viewPager = findViewById(R.id.viewpagerSearch);
        // ViewPagerAdapterSearch adapter = new ViewPagerAdapterSearch(getSupportFragmentManager(), intent);
        //viewPager.setAdapter(adapter);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        recyclerView = findViewById(R.id.recycler_id_search);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        ArrayList<Doc> PostList = intent.getParcelableArrayListExtra("ListObject");

        if (PostList != null) {
            AdapterArticleSearch adapter = new AdapterArticleSearch(this, PostList);
            recyclerView.setAdapter(adapter);

            return;
        }


        String apiKey = "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk";


        ArrayList<String> section = intent.getStringArrayListExtra("section");

        String searchText = intent.getStringExtra("search_text");
        String begin_date = null;
        try {
            begin_date = Processor.dateFormatterC(intent.getStringExtra("begin_date"));
           // Log.d(TAG, "begin_date: " + begin_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String endDate = null;
        try {
            endDate = Processor.dateFormatterC(intent.getStringExtra("endDate"));
            //Log.d(TAG, "endDate: " + endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        ApiUtil.getServiceClass().getSearch(searchText, section, begin_date, endDate, apiKey).enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArrayList<Doc> postList = (ArrayList<Doc>) response.body().getResponse().getDocs();
                    AdapterArticleSearch adapter = new AdapterArticleSearch(SearchResultActivity.this, postList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArticleSearchResponse> call, Throwable t) {
               // Log.d(TAG, "error loading from API");
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
