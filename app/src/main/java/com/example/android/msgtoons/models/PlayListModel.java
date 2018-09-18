package com.example.android.msgtoons.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayListModel implements Parcelable {

    public String id="";
    private String title = "";
    private String description = "";
    private String publishedAt = "";
    private String thumbnail = "";
    private String video_id = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(publishedAt);
        dest.writeString(thumbnail);
        dest.writeString(video_id);
    }

    public PlayListModel() {
        super();
    }

    protected PlayListModel(Parcel in) {
        this();
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.publishedAt = in.readString();
        this.thumbnail = in.readString();
        this.video_id = in.readString();
    }

    public static final Creator<PlayListModel> CREATOR = new Creator<PlayListModel>() {
        @Override
        public PlayListModel createFromParcel(Parcel in) {
            return new PlayListModel(in);
        }

        @Override
        public PlayListModel[] newArray(int size) { return new PlayListModel[size];}
    };
}
