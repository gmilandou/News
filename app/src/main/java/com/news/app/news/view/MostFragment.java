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
import com.news.app.news.controller.AdapterMostPopular;
import com.news.app.news.controller.ApiUtil;
import com.news.app.news.model.mostpopular.MostPopularNYTResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostFragment extends Fragment {

    private final String TAG = "MYLOG";
    int position;
    private RecyclerView recyclerView;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        MostFragment tabFragment = new MostFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        recyclerView = view.findViewById(R.id.recycler_id);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ApiUtil.getServiceClass().getMostPopular().enqueue(new Callback<MostPopularNYTResponse>() {
            @Override
            public void onResponse(Call<MostPopularNYTResponse> call, Response<MostPopularNYTResponse> response) {
                if (response.isSuccessful()) {
                    MostPopularNYTResponse postList = response.body();
                    AdapterMostPopular adapter = new AdapterMostPopular(getContext(), postList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MostPopularNYTResponse> call, Throwable t) {
                Log.d(TAG, "error loading from API");
            }
        });
        return view;

    }


}