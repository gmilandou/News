package com.news.app.news.model.articlesearch;

import java.util.List;

/**
 * Created by USER on 4/29/2019.
 */

public class ArticleSearchResponse {

    private String status;
    private String copyright;
    private Response response;


    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response reponse) {
        this.response = reponse;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArticleSearch [status = " + status + ", copyright = " + copyright + ", response = " + response + "]";
    }
}
