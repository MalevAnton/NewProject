package com.example.mydeaf.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Alphabet implements Parcelable {

    int ID;
    String Name;
    String LookLike;
    String Comment;
    String Image;

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getLookLike() {
        return LookLike;
    }

    public String getComment() {
        return Comment;
    }

    public String getImage() {
        return Image;
    }

    public int getYearOsnov() {
        return YearOsnov;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLookLike(String lookLike) {
        LookLike = lookLike;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setYearOsnov(int yearOsnov) {
        YearOsnov = yearOsnov;
    }

    public Alphabet(int ID, String name, String lookLike, String comment, String image, int yearOsnov)
    {
        this.ID = ID;
        Name = name;
        LookLike = lookLike;
        Comment = comment;
        Image = image;
        YearOsnov = yearOsnov;
    }

    int YearOsnov;

    protected Alphabet(Parcel in) {
    }

    public static final Creator<Alphabet> CREATOR = new Creator<Alphabet>() {
        @Override
        public Alphabet createFromParcel(Parcel in) {
            return new Alphabet(in);
        }

        @Override
        public Alphabet[] newArray(int size) {
            return new Alphabet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
