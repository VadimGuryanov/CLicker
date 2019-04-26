package com.example.cliker.shop.boost;

public class Booster {

    private String name, description;
    private int point, image;
    private boolean isSold;
    private int boost;

    public Booster(String name, String description, int image, int point, int boost, boolean isSold) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.point = point;
        this.isSold = isSold;
        this.boost = boost;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
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
