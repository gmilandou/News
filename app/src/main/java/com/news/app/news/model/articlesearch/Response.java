package com.news.app.news.model.articlesearch;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("docs")
    @Expose
    private List<Doc> docs = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public Response(Meta meta) {
        this.meta = meta;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    @Override
    public String toString() {
        return "ArticleSearch [docs = " + docs + ", meta = " + meta + "]";
    }
}