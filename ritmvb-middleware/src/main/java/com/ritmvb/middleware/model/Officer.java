package com.ritmvb.middleware.model;

public class Officer {
    private String name;
    private String position;
    private String email;

    public Officer(String name, String position, String email) {
        this.name = name;
        this.position = position;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Officer) {
            Officer that = (Officer) obj;
            return this.name.equals(that.name) && this.position.equals(that.position) && this.email.equals(that.email);
        } else {
            return false;
        }
    }

}