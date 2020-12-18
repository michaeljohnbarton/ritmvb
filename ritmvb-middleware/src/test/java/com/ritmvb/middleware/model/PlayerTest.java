package com.ritmvb.middleware.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player CuT;

    @BeforeEach
    public void setupEach() {
        CuT = new Player("name", 0, "imageURL", "position", 1, "height", "major", "hometown");
    }

    @Test
    public void equals_otherObjectTypePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals("aString"));
    }

    @Test
    public void equals_differentNamePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("diffName", 0, "imageURL", "position", 1, "height", "major", "hometown")));
    }

    @Test
    public void equals_differentNumberPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("name", -1, "imageURL", "position", 1, "height", "major", "hometown")));
    }

    @Test
    public void equals_differentImageURLPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("name", 0, "diffImageURL", "position", 1, "height", "major", "hometown")));
    }

    @Test
    public void equals_differentPositionPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("name", 0, "imageURL", "diffPosition", 1, "height", "major", "hometown")));
    }

    @Test
    public void equals_differentYearPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("name", 0, "imageURL", "position", -2, "height", "major", "hometown")));
    }

    @Test
    public void equals_differentHeightPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("name", 0, "imageURL", "position", 1, "diffHeight", "major", "hometown")));
    }

    @Test
    public void equals_differentMajorPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("name", 0, "imageURL", "position", 1, "height", "diffMajor", "hometown")));
    }

    @Test
    public void equals_differentHometownPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("name", 0, "imageURL", "position", 1, "height", "major", "diffHometown")));
    }

    @Test
    public void equals_completelyDifferentPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Player("diffName", -1, "diffImageURL", "diffPosition", -2, "diffHeight", "diffMajor", "diffHometown")));
    }

    @Test
    public void equals_samePassed_returnsTrue() {
        // Act/Assert
        assertTrue(CuT.equals(new Player("name", 0, "imageURL", "position", 1, "height", "major", "hometown")));
    }
    
}