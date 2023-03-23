package com.example.animejson.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Anime implements Parcelable {
    private int id;
    private String name;
    private String description;
    private String type;
    private int year;
    private String image;
    private String image2;
    private String originalname;
    private String rating;
    private String demography;
    private String genre;
    private Boolean active;
    private String favorite;

    private String[] animesfavorites;
    private String[] animevideos;

    public Anime() {
    }

    public Anime(int id, String name, String description, String type, int year, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.year = year;
        this.image = image;
    }

    protected Anime(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        type = in.readString();
        year = in.readInt();
        image = in.readString();
        image2 = in.readString();
        originalname = in.readString();
        rating = in.readString();
        demography = in.readString();
        genre = in.readString();
        byte tmpActive = in.readByte();
        active = tmpActive == 0 ? null : tmpActive == 1;
        favorite = in.readString();
        animesfavorites = in.createStringArray();
        animevideos = in.createStringArray();
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDemography() {
        return demography;
    }

    public void setDemography(String demography) {
        this.demography = demography;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String[] getAnimesfavorites() {
        return animesfavorites;
    }

    public void setAnimesfavorites(String[] animesfavorites) {
        this.animesfavorites = animesfavorites;
    }

    public String[] getAnimevideos() {
        return animevideos;
    }

    public void setAnimevideos(String[] animevideos) {
        this.animevideos = animevideos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(type);
        parcel.writeInt(year);
        parcel.writeString(image);
        parcel.writeString(image2);
        parcel.writeString(originalname);
        parcel.writeString(rating);
        parcel.writeString(demography);
        parcel.writeString(genre);
        parcel.writeByte((byte) (active == null ? 0 : active ? 1 : 2));
        parcel.writeString(favorite);
        parcel.writeStringArray(animesfavorites);
        parcel.writeStringArray(animevideos);
    }
}
