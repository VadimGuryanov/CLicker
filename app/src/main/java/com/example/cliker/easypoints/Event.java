package com.example.cliker.easypoints;

public class Event {

    private String name;
    private String description;
    private int point;
    private int image;
    private boolean isComplete;


    public Event(String name, String description, int point, int image, boolean isComplete) {
        this.name = name;
        this.description = description;
        this.point = point;
        this.image = image;
        this.isComplete = isComplete;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPoint() {
        return point;
    }

    public int getImage() {
        return image;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
