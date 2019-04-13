package com.example.cliker.easypoints;

public class Event {

    private String name;
    private String description;
    private int point;


    public Event(String name, String description, int point) {
        this.name = name;
        this.point = point;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public String getDescription() {
        return description;
    }
}
