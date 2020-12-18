package com.ritmvb.middleware.model;

public class Player {

    private String name;
    private int number;
    private String imageURL;
    private String position;
    private int year;
    private String height;
    private String major;
    private String hometown;

    public Player(String name, int number, String imageURL, String position, int year, String height, String major,
            String hometown) {
        this.name = name;
        this.number = number;
        this.imageURL = imageURL;
        this.position = position;
        this.year = year;
        this.height = height;
        this.major = major;
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPosition() {
        return position;
    }

    public int getYear() {
        return year;
    }

    public String getHeight() {
        return height;
    }

    public String getMajor() {
        return major;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player that = (Player) obj;
            return this.name.equals(that.name) && this.number == that.number && this.imageURL.equals(that.imageURL)
                    && this.position.equals(that.position) && this.year == that.year && this.height.equals(that.height)
                    && this.major.equals(that.major) && this.hometown.equals(that.hometown);
        } else {
            return false;
        }
    }

}