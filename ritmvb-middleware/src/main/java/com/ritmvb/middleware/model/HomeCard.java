package com.ritmvb.middleware.model;

public class HomeCard {
    private String title;
    private String route;
    private String imageURL;

    public HomeCard(String title, String route, String imageURL) {
        this.title = title;
        this.route = route;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getRoute() {
        return route;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HomeCard) {
            HomeCard that = (HomeCard) obj;
            return this.title.equals(that.title) && this.route.equals(that.route)
                    && this.imageURL.equals(that.imageURL);
        } else {
            return false;
        }
    }
}