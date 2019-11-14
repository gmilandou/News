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

    public NewYorkTimesResponse(String copyright, String last_updated, List<Results> results, String num_results, String status) {
        this.copyright = copyright;
        this.last_updated = last_updated;
        this.results = results;
        this.num_results = num_results;
        this.status = status;
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


    @Override
    public String toString() {
        return "NewYorkTimesResponse [copyright = " + copyright + ", last_updated = " + last_updated + ", section = " + section + ", results = " + results + ", num_results = " + num_results + ", status = " + status + "]";
    }
}
