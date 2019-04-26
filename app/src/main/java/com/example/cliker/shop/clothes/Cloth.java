package com.example.cliker.shop.clothes;

public class Cloth {

    private String name, description;
    private int point, image;
    private boolean isSold;
    private int image_boy;

    public Cloth(String name, String description, int image, int point, int image_boy, boolean isSold) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.point = point;
        this.isSold = isSold;
        this.image_boy = image_boy;
    }

    public int getImage_boy() {
        return image_boy;
    }

    public void setImage_boy(int image_boy) {
        this.image_boy = image_boy;
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
