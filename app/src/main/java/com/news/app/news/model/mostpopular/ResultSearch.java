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


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public Integer getEmailCount() {
        return emailCount;
    }

    public void setEmailCount(Integer emailCount) {
        this.emailCount = emailCount;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public Integer getEtaId() {
        return etaId;
    }

    public void setEtaId(Integer etaId) {
        this.etaId = etaId;
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

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getNytdsection() {
        return nytdsection;
    }

    public void setNytdsection(String nytdsection) {
        this.nytdsection = nytdsection;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String  getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    public List<String> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public String getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(String perFacet) {
        this.perFacet = perFacet;
    }

    public String getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(String geoFacet) {
        this.geoFacet = geoFacet;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {

        return "Result [url = " + url + ", adxKeywords = " + adxKeywords + ", subsection = " + subsection + ", emailCount = " + emailCount + ", countType = " + countType + ", column = " + column + ", etaId = " + etaId + ", section = " + section + ", id = " + id + ", assetId = " + assetId + ", nytdsection = " + nytdsection + ", byline = " + byline + ", type = " + type + ", title = " + title + ", _abstract = " + _abstract + ", publishedDate = " + publishedDate + ", source = " + source + ", updated = " + updated + ", desFacet = " + desFacet + ", orgFacet = " + orgFacet + ", perFacet = " + perFacet + ", geoFacet = " + geoFacet + ", media = " + media + ", uri = " + uri + "]";
    }





}
