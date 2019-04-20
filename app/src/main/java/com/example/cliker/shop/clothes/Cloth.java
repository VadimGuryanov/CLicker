package com.example.cliker.shop.clothes;

import android.media.Image;

import java.io.File;

public class Cloth {

    private String name, description;
    private Image image;
    private int point;

    public Cloth(String name, String description, Image image, int point) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.point = point;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
