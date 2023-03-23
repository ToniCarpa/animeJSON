package com.example.animejson.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Favorite implements Parcelable {
    private ArrayList<Anime> animefavorites;

    public Favorite(ArrayList<Anime> animefavorites) {
        this.animefavorites = animefavorites;
    }

    public ArrayList<Anime> getAnimefavorites() {
        return animefavorites;
    }

    public void setAnimefavorites(ArrayList<Anime> animefavorites) {
        this.animefavorites = animefavorites;
    }

    protected Favorite(Parcel in) {
        animefavorites = in.createTypedArrayList(Anime.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(animefavorites);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Favorite> CREATOR = new Creator<Favorite>() {
        @Override
        public Favorite createFromParcel(Parcel in) {
            return new Favorite(in);
        }

        @Override
        public Favorite[] newArray(int size) {
            return new Favorite[size];
        }
    };
}
