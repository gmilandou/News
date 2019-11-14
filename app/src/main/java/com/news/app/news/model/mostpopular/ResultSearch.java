package com.news.app.news.model.mostpopular;

import java.util.List;


/**
 * Created by USER on 6/11/2019.
 */

public class ResultSearch {

    private String url;
    private String adxKeywords;
    private String subsection;
    private Integer emailCount;
    private String countType;
    private Object column;
    private Integer etaId;
    private String section;
    private Long id;
    private Integer assetId;
    private String nytdsection;
    private String byline;
    private String type;
    private String title;
    private String _abstract;
    private String publishedDate;
    private String source;
    private String updated;
    private List<String> desFacet = null;
    private List<String> orgFacet = null;
    private String perFacet;
    private String geoFacet;
    private List<Medium> media = null;
    private String uri;

    public ResultSearch(String url, String adxKeywords, String subsection, Integer emailCount, String countType, Object column, Integer etaId, Integer assetId, String nytdsection, String byline, String type, String title, String anAbstract, String publishedDate, String source, String updated, String perFacet, String geoFacet, String uri) {
        this.url = url;
        this.adxKeywords = adxKeywords;
        this.subsection = subsection;
        this.emailCount = emailCount;
        this.countType = countType;
        this.column = column;
        this.etaId = etaId;
        this.assetId = assetId;
        this.nytdsection = nytdsection;
        this.byline = byline;
        this.type = type;
        this.title = title;
        _abstract = anAbstract;
        this.publishedDate = publishedDate;
        this.source = source;
        this.updated = updated;
        this.perFacet = perFacet;
        this.geoFacet = geoFacet;
        this.uri = uri;
    }


    public String getUrl() {
        return url;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public String getUpdated() {
        return updated;
    }


    public List<Medium> getMedia() {
        return media;
    }


    @Override
    public String toString() {

        return "Result [url = " + url + ", adxKeywords = " + adxKeywords + ", subsection = " + subsection + ", emailCount = " + emailCount + ", countType = " + countType + ", column = " + column + ", etaId = " + etaId + ", section = " + section + ", id = " + id + ", assetId = " + assetId + ", nytdsection = " + nytdsection + ", byline = " + byline + ", type = " + type + ", title = " + title + ", _abstract = " + _abstract + ", publishedDate = " + publishedDate + ", source = " + source + ", updated = " + updated + ", desFacet = " + desFacet + ", orgFacet = " + orgFacet + ", perFacet = " + perFacet + ", geoFacet = " + geoFacet + ", media = " + media + ", uri = " + uri + "]";
    }


}
