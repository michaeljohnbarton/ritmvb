package com.ritmvb.middleware.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactUsTest {
    
    ContactUsContent CuT;

    @BeforeEach
    public void setupEach() {
        CuT = new ContactUsContent("text1", "email", "text2");
    }

    @Test
    public void equals_otherObjectTypePassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals("aString"));
    }

    @Test
    public void equals_differentText1Passed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new ContactUsContent("diffText1", "email", "text2")));
    }

    @Test
    public void equals_differentEmailPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new ContactUsContent("text1", "diffEmail", "text2")));
    }

    @Test
    public void equals_differentText2Passed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new ContactUsContent("text1", "email", "diffText2")));
    }

    @Test
    public void equals_completelyDifferentPassed_returnsFalse() {
        // Act/Assert
        assertFalse(CuT.equals(new ContactUsContent("diffText1", "diffEmail", "diffText2")));
    }

    @Test
    public void equals_samePassed_returnsTrue() {
        // Act/Assert
        assertTrue(CuT.equals(new ContactUsContent("text1", "email", "text2")));
    }

}