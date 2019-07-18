package com.news.app.news.model.mostpopular;

/**
 * Created by USER on 6/11/2019.
 */

public class MediaMetadatum {


    private String url;
    private String format;
    private Integer height;
    private Integer width;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public String toString() {
         return "MediaMetatum [url = " + url + ", format = " + format + ", height = " + height + ", width = " + width + "]";
    }

}