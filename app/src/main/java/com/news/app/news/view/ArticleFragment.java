package com.news.app.news.view;

/**
 * Created by USER on 4/29/2019.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.app.news.R;
import com.news.app.news.controller.Adapter;
import com.news.app.news.controller.AdapterArticleSearch;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.model.articlesearch.ArticleSearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleFragment extends Fragment {

    private final String TAG = "MYLOG";
    int position;
    private RecyclerView recyclerView;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        ArticleFragment tabFragment = new ArticleFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_id);
        final LinearLayoutManager layoutManager = new  LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ApiUtil.getServiceClass().getArticleSearch().enqueue(new Callback<ArticleSearchResponse>() {
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
        return view ;

    }


}