package com.example.animejson.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Animevideos implements Parcelable {
    private int id;
    private String episode;
    private String url;
    Anime anime;

    public Animevideos(int id, String episode, String url) {
        this.id = anime.getId();
        this.episode = episode;
        this.url = url;
    }

    protected Animevideos(Parcel in) {
        id = in.readInt();
        episode = in.readString();
        url = in.readString();
        anime = in.readParcelable(Anime.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(episode);
        dest.writeString(url);
        dest.writeParcelable(anime, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Animevideos> CREATOR = new Creator<Animevideos>() {
        @Override
        public Animevideos createFromParcel(Parcel in) {
            return new Animevideos(in);
        }

        @Override
        public Animevideos[] newArray(int size) {
            return new Animevideos[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
