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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getApprovedForSyndication() {
        return approved_for_syndication;
    }

    public void setApproved_for_syndication(Integer approved_for_syndication) {
        this.approved_for_syndication = approved_for_syndication;
    }

    public List<MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }


    @Override
    public String toString() {
        return "Medium [type = " + type + ", subtype = " + subtype + ", caption = " + caption + ", copyright = " + copyright + ", approved_for_syndication = " + approved_for_syndication + ", mediaMetadata = " + mediaMetadata + "]";
    }

}
