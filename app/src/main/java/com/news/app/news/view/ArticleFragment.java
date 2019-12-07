package com.news.app.news.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.app.news.R;
import com.news.app.news.controller.AdapterArticleSearch;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;
import com.news.app.news.model.articlesearch.Doc;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleFragment extends Fragment {

    private final String TAG = "MYLOG";
    //int position;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout progress_circular;



    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        recyclerView = view.findViewById(R.id.recycler_id);
        progress_circular = view.findViewById(R.id.progress_circular);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        progress_circular.setRefreshing(true);

        progress_circular.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                progress_circular.setRefreshing(true);
                loadRecord();
            }
        });

        loadRecord();



        return view;

    }

    public void loadRecord(){

        ApiUtil.getServiceClass().getArticleSearch().enqueue(new Callback<ArticleSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<ArticleSearchResponse> call, Response<ArticleSearchResponse> response) {
                if (response.isSuccessful()) {
                    ArrayList<Doc> postList = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                        postList = (ArrayList<Doc>) Objects.requireNonNull(response.body()).getResponse().getDocs();
                    }
                    AdapterArticleSearch adapter = new AdapterArticleSearch(getContext(), postList);
                    recyclerView.setAdapter(adapter);
                }
                progress_circular.setRefreshing(false);

            }

            @Override
            public void onFailure(@NonNull Call<ArticleSearchResponse> call, Throwable t) {
                Log.d(TAG, "error loading from API");
                progress_circular.setRefreshing(false);

            }
        });
    }

}