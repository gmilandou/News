package com.news.app.news.model.topstories;

/**
 * Created by USER on 4/29/2019.
 */

public class Multimedia {

    private String copyright;
    private String subtype;
    private String format;
    private String width;
    private String caption;
    private String type;
    private String url;
    private String height;

    public Multimedia(String copyright, String subtype, String format, String width, String caption, String type, String url, String height) {
        this.copyright = copyright;
        this.subtype = subtype;
        this.format = format;
        this.width = width;
        this.caption = caption;
        this.type = type;
        this.url = url;
        this.height = height;
    }


    public String getUrl() {
        return url;
    }


    @Override
    public String toString() {
        return "Multimedia [copyright = " + copyright + ", subtype = " + subtype + ", format = " + format + ", width = " + width + ", caption = " + caption + ", type = " + type + ", url = " + url + ", height = " + height + "]";
    }
}
