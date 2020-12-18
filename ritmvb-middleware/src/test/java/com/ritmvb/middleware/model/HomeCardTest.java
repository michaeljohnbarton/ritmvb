package com.ritmvb.middleware.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeCardTest {

    HomeCard CuT;

    @BeforeEach
    public void setupEach() {
        CuT = new HomeCard("title", "route", "imageURL");
    }

    @Test
    public void equals_otherObjectTypePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals("aString"));
    }

    @Test
    public void equals_differentTitlePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new HomeCard("diffTitle", "route", "imageURL")));
    }

    @Test
    public void equals_differentRoutePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new HomeCard("title", "diffRoute", "imageURL")));
    }

    @Test
    public void equals_differentImageURLPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new HomeCard("title", "route", "diffImageURL")));
    }

    @Test
    public void equals_completelyDifferentPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new HomeCard("diffTitle", "diffRoute", "diffImageURL")));
    }

    @Test
    public void equals_samePassed_returnsTrue() {
        // Act/Assert
        assertTrue(CuT.equals(new HomeCard("title", "route", "imageURL")));
    }
    
}