package com.example.mydeaf.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Number implements Parcelable {

    int ID;
    String NameNum;
    String LookLikeNum;
    String CommentNum;
    String ImageNum;

    public int getID() {
        return ID;
    }

    public String getNameNum() {
        return NameNum;
    }
    public String getLookLikeNum() {
        return LookLikeNum;
    }

    public String getCommentNum() {
        return CommentNum;
    }

    public String getImageNum() {
        return ImageNum;
    }

    public int getYearOsnovNum() {
        return YearOsnovNum;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNameNum(String name) {
        NameNum = name;
    }

    public void setLookLikeNum(String lookLike) {
        LookLikeNum = lookLike;
    }

    public void setCommentNum(String comment) {
        CommentNum = comment;
    }

    public void setImageNum(String image) {
        ImageNum = image;
    }

    public void setYearOsnovNum(int yearOsnovNum) {
        YearOsnovNum = yearOsnovNum;
    }

    public Number(int ID, String nameNum, String lookLikeNum, String commentNum, String imageNum, int yearOsnovNum)
    {
        this.ID = ID;
        NameNum = nameNum;
        LookLikeNum = lookLikeNum;
        CommentNum = commentNum;
        ImageNum = imageNum;
        YearOsnovNum = yearOsnovNum;
    }

    int YearOsnovNum;

    protected Number(Parcel in) {
    }

    public static final Creator<Number> CREATOR = new Creator<Number>() {
        @Override
        public Number createFromParcel(Parcel in) {
            return new Number(in);
        }

        @Override
        public Number[] newArray(int size) {
            return new Number[size];
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
