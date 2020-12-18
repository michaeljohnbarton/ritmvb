package com.ritmvb.middleware.model;

public class ContactUsContent {
    private String text1;
    private String email;
    private String text2;

    public ContactUsContent(String text1, String email, String text2) {
        this.text1 = text1;
        this.email = email;
        this.text2 = text2;
    }

    public String getText1() {
        return text1;
    }

    public String getEmail() {
        return email;
    }

    public String getText2() {
        return text2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ContactUsContent) {
            ContactUsContent that = (ContactUsContent) obj;
            return this.text1.equals(that.text1) && this.email.equals(that.email) && this.text2.equals(that.text2);
        } else {
            return false;
        }
    }

}