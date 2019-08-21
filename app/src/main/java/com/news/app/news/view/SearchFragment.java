package com.news.app.news.view;

/**
 * Created by USER on 4/29/2019.
 */

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.news.app.news.controller.SearchResultActivity;
import com.news.app.news.R;
import com.news.app.news.controller.AdapterArticleSearch;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.controller.SearchResultActivity;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private final String TAG = "MYLOG";
    int position;
    private RecyclerView recyclerView;

    Intent intent= null ;

    @SuppressLint("ValidFragment")
    public SearchFragment(Intent intent){
        this.intent = intent ;
    }

    public SearchFragment(){

    }

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        SearchFragment tabFragment = new SearchFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment_tab, container, false);
        recyclerView = view.findViewById(R.id.recycler_id_search);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //String searchText = "Trump";
        //String section = "Politics";
        //String begin_date = "20170101";
        String apiKey = "3zQ75lelXXmxuZpVMSLzaD06md8zaPhk";
        //String endDate = "20190807";



       String searchText = intent.getStringExtra("search_text");
       String section = intent.getStringExtra("section");
       String begin_date = intent.getStringExtra("begin_date");
       String endDate = intent.getStringExtra("endDate");

        Log.d(TAG, "This is my passed data from Fragment: " + section);

        ApiUtil.getServiceClass().getSearch(searchText , section, begin_date, endDate, apiKey).enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArticleSearchResponse postList = response.body();
                    AdapterArticleSearch adapter = new AdapterArticleSearch(getContext(), postList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArticleSearchResponse> call, Throwable t) {
                Log.d(TAG, "error loading from API");
            }
        });
        return view;

    }

    /*public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //String mParam1 = getArguments().getString("params");
        }
    }*/

}