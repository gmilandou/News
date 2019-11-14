package com.news.app.news.model.mostpopular;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by USER on 6/11/2019.
 */

public class Medium {


    @SerializedName("type")
    @Expose
    private String type;

    private String subtype;

    private String caption;

    private String copyright;

    private Integer approved_for_syndication;

    @SerializedName("media-metadata")
    @Expose
    private List<MediaMetadatum> mediaMetadata = null;

    public Medium(String type, String subtype, String caption, String copyright, Integer approved_for_syndication) {
        this.type = type;
        this.subtype = subtype;
        this.caption = caption;
        this.copyright = copyright;
        this.approved_for_syndication = approved_for_syndication;
    }


    public List<MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }


    @Override
    public String toString() {
        return "Medium [type = " + type + ", subtype = " + subtype + ", caption = " + caption + ", copyright = " + copyright + ", approved_for_syndication = " + approved_for_syndication + ", mediaMetadata = " + mediaMetadata + "]";
    }

}
