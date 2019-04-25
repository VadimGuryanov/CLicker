package com.example.cliker.shop.tech;

public class Devise {
    private String name, description;
    private int point, image;
    private boolean isSold;
    private int boost;

    public Devise(String name, String description, int image, int point, int boost) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.point = point;
        this.isSold = false;
        this.boost = boost;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

