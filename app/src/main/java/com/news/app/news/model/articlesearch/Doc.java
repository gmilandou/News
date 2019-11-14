package com.news.app.news.model.articlesearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by USER on 7/10/2019.
 */

public class Doc implements Parcelable {

    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("lead_paragraph")
    @Expose
    private String leadParagraph;
    @SerializedName("abstract")
    @Expose
    private String _abstract;

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("multimedia")
    @Expose
    private List<Multimedium> multimedia = null;

    @SerializedName("pub_date")
    @Expose
    private String pubDate;
    @SerializedName("document_type")
    @Expose
    private String documentType;
    @SerializedName("news_desk")
    @Expose
    private String newsDesk;
    @SerializedName("section_name")
    @Expose
    private String sectionName;
    @SerializedName("type_of_material")
    @Expose
    private String typeOfMaterial;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("word_count")
    @Expose
    private Integer wordCount;
    @SerializedName("uri")
    @Expose
    private String uri;

    private Doc(Parcel in) {
        webUrl = in.readString();
        snippet = in.readString();
        leadParagraph = in.readString();
        _abstract = in.readString();
        source = in.readString();
        pubDate = in.readString();
        documentType = in.readString();
        newsDesk = in.readString();
        sectionName = in.readString();
        typeOfMaterial = in.readString();
        //Testing for my image

        id = in.readString();
        if (in.readByte() == 0) {
            wordCount = null;
        } else {
            wordCount = in.readInt();
        }
        uri = in.readString();
    }

    public static final Creator<Doc> CREATOR = new Creator<Doc>() {
        @Override
        public Doc createFromParcel(Parcel in) {
            return new Doc(in);
        }

        @Override
        public Doc[] newArray(int size) {
            return new Doc[size];
        }
    };

    public String getWebUrl() {
        return webUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public List<Multimedium> getMultimedia() {
        return multimedia;
    }


    public String getPubDate() {
        return pubDate;
    }

    public String getSectionName() {
        return sectionName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(webUrl);
        dest.writeString(snippet);
        dest.writeString(leadParagraph);
        dest.writeString(_abstract);
        dest.writeString(source);
        dest.writeString(pubDate);
        dest.writeString(documentType);
        dest.writeString(newsDesk);
        dest.writeString(sectionName);
        dest.writeString(typeOfMaterial);
        dest.writeString(id);
        if (wordCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(wordCount);
        }
        dest.writeString(uri);
    }
}