package com.news.app.news.controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.news.app.news.BuildConfig;
import com.news.app.news.R;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.articlesearch.Doc;
import com.news.app.news.utility.Processor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout progress_circular;


    public SearchResultActivity() {
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        recyclerView = findViewById(R.id.recycler_id_search);
        progress_circular = findViewById(R.id.progress_circular_search);

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


        final String apiKey = BuildConfig.GoogleSecAPIKEY;


        final ArrayList<String> section = intent.getStringArrayListExtra("section");

        final String searchText = intent.getStringExtra("search_text");
        String begin_date = null;
        try {
            begin_date = Processor.dateFormatterC(intent.getStringExtra("begin_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String endDate = null;
        try {
            endDate = Processor.dateFormatterC(intent.getStringExtra("endDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        progress_circular.setRefreshing(true);

        final String finalBegin_date = begin_date;
        final String finalEndDate = endDate;
        progress_circular.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                progress_circular.setRefreshing(true);
                ApiUtil.getServiceClass().getSearch(searchText, section, finalBegin_date, finalEndDate, apiKey).enqueue(new Callback<ArticleSearchResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<ArticleSearchResponse> call, @NonNull Response<ArticleSearchResponse> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            ArrayList<Doc> postList = (ArrayList<Doc>) response.body().getResponse().getDocs();
                            AdapterArticleSearch adapter = new AdapterArticleSearch(SearchResultActivity.this, postList);
                            recyclerView.setAdapter(adapter);
                        }
                        progress_circular.setRefreshing(false);

                    }

                    @Override
                    public void onFailure(@NonNull Call<ArticleSearchResponse> call, @NonNull Throwable t) {
                        progress_circular.setRefreshing(false);

                    }
                });
            }
        });

        //   loadRecord();

        ApiUtil.getServiceClass().getSearch(searchText, section, begin_date, endDate, apiKey).enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<ArticleSearchResponse> call, @NonNull Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    ArrayList<Doc> postList = (ArrayList<Doc>) response.body().getResponse().getDocs();
                    AdapterArticleSearch adapter = new AdapterArticleSearch(SearchResultActivity.this, postList);
                    recyclerView.setAdapter(adapter);
                }
                progress_circular.setRefreshing(false);

            }

            @Override
            public void onFailure(@NonNull Call<ArticleSearchResponse> call, @NonNull Throwable t) {
                progress_circular.setRefreshing(false);

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
