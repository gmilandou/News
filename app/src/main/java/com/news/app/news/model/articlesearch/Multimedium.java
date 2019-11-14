package com.news.app.news.model.articlesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 7/10/2019.
 */

public class Multimedium {

    @SerializedName("url")
    @Expose
    private String url;

    public Multimedium(String url) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }


}