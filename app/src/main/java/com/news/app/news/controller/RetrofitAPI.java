package com.news.app.news.controller;

/*
 Created by USER on 4/22/2019.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitAPI {

    @SuppressWarnings("SameParameterValue")
    static Retrofit getRetrofit(String url) {
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
