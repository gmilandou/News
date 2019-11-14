package com.news.app.news.model.topstories;

import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 4/29/2019.
 */

public class Results {

    private List<String> per_facet;

    private String subsection;

    private String item_type;

    private String[] org_facet;

    private String section;

    private String _abstract;

    private String title;

    private List<String> des_facet;

    private String url;

    private String short_url;

    private String material_type_facet;

    private List<Multimedia> multimedia;

    private String[] geo_facet;

    private String updated_date;

    private String created_date;

    private String byline;

    private String published_date;

    private String kicker;

    public Results(List<String> per_facet, String subsection, String item_type, String[] org_facet, String anAbstract, String title, List<String> des_facet, String url, String short_url, String material_type_facet, List<Multimedia> multimedia, String[] geo_facet, String updated_date, String created_date, String byline, String published_date, String kicker) {
        this.per_facet = per_facet;
        this.subsection = subsection;
        this.item_type = item_type;
        this.org_facet = org_facet;
        _abstract = anAbstract;
        this.title = title;
        this.des_facet = des_facet;
        this.url = url;
        this.short_url = short_url;
        this.material_type_facet = material_type_facet;
        this.multimedia = multimedia;
        this.geo_facet = geo_facet;
        this.updated_date = updated_date;
        this.created_date = created_date;
        this.byline = byline;
        this.published_date = published_date;
        this.kicker = kicker;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }


    public List<Multimedia> getMultimedia() {
        return multimedia;
    }


    public String getUpdated_date() {
        return updated_date;
    }


    @Override
    public String toString() {
        return "Result [per_facet = " + per_facet + ", subsection = " + subsection + ", item_type = " + item_type + ", org_facet = " + Arrays.toString(org_facet) + ", section = " + section + ", abstract = " + _abstract + ", title = " + title + ", des_facet = " + des_facet + ", url = " + url + ", short_url = " + short_url + ", material_type_facet = " + material_type_facet + ", multimedia = " + multimedia + ", geo_facet = " + Arrays.toString(geo_facet) + ", updated_date = " + updated_date + ", created_date = " + created_date + ", byline = " + byline + ", published_date = " + published_date + ", kicker = " + kicker + "]";
    }
}
