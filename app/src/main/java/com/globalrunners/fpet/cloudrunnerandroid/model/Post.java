package com.globalrunners.fpet.cloudrunnerandroid.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.security.Timestamp;

public class Post implements Parcelable {

    private int id;
    private String timestamp;
    private String title;
    private String text;

    public Post(int id, String timestamp, String title, String text) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.text = text;
    }

    public Post(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.text = in.readString();
        this.timestamp = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(text);
        parcel.writeString(timestamp);
    }

    public static final Parcelable.Creator<Post> CREATOR
            = new Parcelable.Creator<Post>() {
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
