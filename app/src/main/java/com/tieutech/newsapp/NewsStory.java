package com.tieutech.newsapp;

public class NewsStory {

    int image;
    String title;
    String description;

    public NewsStory(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    //Setters
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    //Getters
    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
