package com.news.app.news.model.mostpopular;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by USER on 4/29/2019.
 */

public class MostPopularNYTResponse {

    private String status;

    private String copyright;

    private Integer num_results;

    private List<ResultSearch> results = null;

    public MostPopularNYTResponse(String status, String copyright, Integer num_results) {
        this.status = status;
        this.copyright = copyright;
        this.num_results = num_results;

    }

    public List<ResultSearch> getResultSearch() {
        return results;
    }

    @NonNull
    @Override
    public String toString() {
        return "MostPopularNYTResponse [status = " + status + ", copyright = " + copyright + ", num_results = " + num_results + ", results = " + results + "]";
    }

}
