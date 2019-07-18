package com.news.app.news.model.mostpopular;

import java.util.List;

/**
 * Created by USER on 4/29/2019.
 */

public class MostPopularNYTResponse {

    private String status;

    private String copyright;

    private Integer num_results;

    private List<ResultSearch> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getnum_results() {
        return num_results;
    }

    public void setnum_results(Integer num_results) {
        this.num_results = num_results;
    }

    public List<ResultSearch> getResultSearch() {
        return results;
    }

    public void setResultSearch(List<ResultSearch> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "MostPopularNYTResponse [status = " + status + ", copyright = " + copyright + ", num_results = " + num_results + ", results = " + results + "]";
    }

}
