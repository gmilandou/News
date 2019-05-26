package com.news.app.news.model.topstories;

import java.util.List;

/**
 * Created by USER on 4/29/2019.
 */

public class NewYorkTimesResponse {

    private String copyright;

    private String last_updated;

    private String section;

    private List<Results> results;

    private String num_results;

    private String status;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getNum_results() {
        return num_results;
    }

    public void setNum_results(String num_results) {
        this.num_results = num_results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NewYorkTimesResponse [copyright = " + copyright + ", last_updated = " + last_updated + ", section = " + section + ", results = " + results + ", num_results = " + num_results + ", status = " + status + "]";
    }
}
