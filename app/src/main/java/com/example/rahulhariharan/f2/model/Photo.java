package com.example.rahulhariharan.f2.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rahulhariharan on 09/04/18.
 */

public class Photo {

    @SerializedName("albumId")
    public int albumId;
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
