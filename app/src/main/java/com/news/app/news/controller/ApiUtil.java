package com.news.app.news.controller;

/**
 * Created by USER on 4/22/2019.
 */


public class ApiUtil {

    private static final String BASE_URL = "https://api.nytimes.com/";

    public static RetrofitInterface getServiceClass() {
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }
}
