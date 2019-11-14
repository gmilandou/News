package com.news.app.news.model.mostpopular;

/**
 * Created by USER on 6/11/2019.
 */

public class MediaMetadatum {


    private String url;
    private String format;
    private Integer height;
    private Integer width;

    public MediaMetadatum(String url, String format, Integer height, Integer width) {
        this.url = url;
        this.format = format;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public String toString() {
        return "MediaMetatum [url = " + url + ", format = " + format + ", height = " + height + ", width = " + width + "]";
    }

}