package com.ritmvb.middleware.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OfficerTest {

    Officer CuT;

    @BeforeEach
    public void setupEach() {
        CuT = new Officer("name", "position", "email");
    }

    @Test
    public void equals_otherObjectTypePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals("aString"));
    }

    @Test
    public void equals_differentNamePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Officer("diffName", "position", "email")));
    }

    @Test
    public void equals_differentPositionPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Officer("name", "diffPosition", "email")));
    }

    @Test
    public void equals_differentEmailPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Officer("name", "position", "diffEmail")));
    }

    @Test
    public void equals_completelyDifferentPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new Officer("diffName", "diffPosition", "diffEmail")));
    }

    @Test
    public void equals_samePassed_returnsTrue() {
        // Act/Assert
        assertTrue(CuT.equals(new Officer("name", "position", "email")));
    }
    
}