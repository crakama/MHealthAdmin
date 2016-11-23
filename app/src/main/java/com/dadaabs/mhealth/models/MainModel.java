package com.dadaabs.mhealth.models;

/**
 * Created by crakama on 11/23/2016.
 */
public class MainModel {

    public MainModel() {

    }

    public MainModel(String title, int img) {
        this.title = title;
        this.img = img;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private  String title;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private  int img;

}
