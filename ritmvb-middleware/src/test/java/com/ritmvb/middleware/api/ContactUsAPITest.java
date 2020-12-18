package com.ritmvb.middleware.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.dao.ContactUsDAO;
import com.ritmvb.middleware.model.ContactUsContent;
import com.ritmvb.middleware.model.Officer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContactUsAPITest {
    
    @InjectMocks
    ContactUsAPI CuT;

    @Mock
    ContactUsDAO contactUsDAOMock;

    @Test
    public void getTitle_defaultCall_returnsTitle() {
        // Arrange
        when(contactUsDAOMock.getTitle()).thenReturn("title");

        // Act
        String actual = CuT.getTitle();

        // Assert
        assertEquals("title", actual);
    }

    @Test
    public void getContent_defaultCall_returnsContactUs() {
        // Arrange
        when(contactUsDAOMock.getContent()).thenReturn(new ContactUsContent("text1", "email", "text2"));

        // Act
        ContactUsContent actual = CuT.getContent();

        // Assert
        assertEquals(new ContactUsContent("text1", "email", "text2"), actual);
    }

    @Test
    public void getOfficers_defaultCall_returnsListOfOfficers() {
        // Arrange
        when(contactUsDAOMock.getOfficers()).thenReturn(Arrays.asList(new Officer("name", "position", "email")));

        // Act
        List<Officer> actual = CuT.getOfficers();

        // Assert
        assertEquals(Arrays.asList(new Officer("name", "position", "email")), actual);
    }

}