package com.example.maisalin_movies;

public class MovieItem {
    private int imageResource;
    private String title;
    private String key_id;


    public MovieItem() {
    }

    public MovieItem(int imageResourse, String title, String key_id) {
        this.imageResource = imageResourse;
        this.title = title;
        this.key_id = key_id;
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

    @Override
    public String toString() {
        return "MovieItem{" +
                "imageResource=" + imageResource +
                ", title='" + title + '\'' +
                ", key_id='" + key_id + '\'' +
                '}';
    }
}
