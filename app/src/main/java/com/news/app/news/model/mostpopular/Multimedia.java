package com.news.app.news.model.mostpopular;

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

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Multimedia [copyright = " + copyright + ", subtype = " + subtype + ", format = " + format + ", width = " + width + ", caption = " + caption + ", type = " + type + ", url = " + url + ", height = " + height + "]";
    }
}
