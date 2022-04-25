package com.example.maisalin_movies;

public class MovieItem {
    private int imageResource;
    private String title;
    private String key_id;
    private String favStatus;


    public MovieItem() {
    }

    public MovieItem(int imageResourse, String title, String key_id, String favStatus) {
        this.imageResource = imageResourse;
        this.title = title;
        this.key_id = key_id;
        this.favStatus = favStatus;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResourse) {
        this.imageResource = imageResourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    @Override
    public String toString() {
        return "MovieItem{" +
                "imageResource=" + imageResource +
                ", title='" + title + '\'' +
                ", key_id='" + key_id + '\'' +
                ", favStatus='" + favStatus + '\'' +
                '}';
    }

}
