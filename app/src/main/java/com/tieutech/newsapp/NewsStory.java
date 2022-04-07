package com.tieutech.newsapp;

//ABOUT:
//Class for each News Story object (used for News Stories and Top News Stories)
public class NewsStory {

    //====== Define variables ======
    int image; //Resource ID of the ImageView of the News Story
    String title; //Title of the News Story
    String description; //Description of the News Story

    //====== Define methods ======
    //Constructor
    public NewsStory(int image, String title, String description) {
        this.image = image; //Image
        this.title = title; //Title
        this.description = description; //Description
    }

    //Setters
    public int getImage() { return image; }
    public String getTitle() { return title; }
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
