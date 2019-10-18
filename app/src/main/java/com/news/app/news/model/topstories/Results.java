package com.news.app.news.model.topstories;

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

    //private Multimedia[] multimedia;

    private List<Multimedia> multimedia;

    private String[] geo_facet;

    private String updated_date;

    private String created_date;

    private String byline;

    private String published_date;

    private String kicker;

    public List<String> getPer_facet() {
        return per_facet;
    }

    public void setPer_facet(List<String> per_facet) {
        this.per_facet = per_facet;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String[] getOrg_facet() {
        return org_facet;
    }

    public void setOrg_facet(String[] org_facet) {
        this.org_facet = org_facet;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDes_facet() {
        return des_facet;
    }

    public void setDes_facet(List<String> des_facet) {
        this.des_facet = des_facet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public String getMaterial_type_facet() {
        return material_type_facet;
    }

    public void setMaterial_type_facet(String material_type_facet) {
        this.material_type_facet = material_type_facet;
    }

    /*public Multimedia[] getMultimedia() {
        return multimedia;
    }*/

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    //public void setMultimedia(Multimedia[] multimedia) {
    // this.multimedia = multimedia;
    // }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public String[] getGeo_facet() {
        return geo_facet;
    }

    public void setGeo_facet(String[] geo_facet) {
        this.geo_facet = geo_facet;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    @Override
    public String toString() {
        return "Result [per_facet = " + per_facet + ", subsection = " + subsection + ", item_type = " + item_type + ", org_facet = " + org_facet + ", section = " + section + ", abstract = " + _abstract + ", title = " + title + ", des_facet = " + des_facet + ", url = " + url + ", short_url = " + short_url + ", material_type_facet = " + material_type_facet + ", multimedia = " + multimedia + ", geo_facet = " + geo_facet + ", updated_date = " + updated_date + ", created_date = " + created_date + ", byline = " + byline + ", published_date = " + published_date + ", kicker = " + kicker + "]";
    }
}
