package com.example.cliker.shop.boost;

public class Booster {

    private String name, description;
    private int point, image;

    public Booster(String name, String description, int image, int point) {
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
