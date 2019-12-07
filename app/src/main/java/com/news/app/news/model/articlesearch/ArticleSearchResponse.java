package com.news.app.news.model.articlesearch;

/*
  Created by USER on 4/29/2019.
 */

import android.support.annotation.NonNull;

public class ArticleSearchResponse {

    private String status;
    private String copyright;
    private Response response;

    public ArticleSearchResponse(String status, String copyright, Response response) {
        this.status = status;
        this.copyright = copyright;
        this.response = response;
    }


    public Response getResponse() {
        return response;
    }


    @NonNull
    @Override
    public String toString() {
        return "ArticleSearch [status = " + status + ", copyright = " + copyright + ", response = " + response + "]";
    }
}
