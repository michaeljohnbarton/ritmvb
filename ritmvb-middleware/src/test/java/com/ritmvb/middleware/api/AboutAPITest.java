package com.ritmvb.middleware.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.dao.AboutDAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AboutAPITest {

    @InjectMocks
    AboutAPI CuT;

    @Mock
    AboutDAO aboutDAOMock;

    @Test
    public void getTitle_defaultCall_returnsTitle() {
        // Arrange
        when(aboutDAOMock.getTitle()).thenReturn("title");

        // Act
        String actual = CuT.getTitle();

        // Assert
        assertEquals("title", actual);
    }

    @Test
    public void getText_defaultCall_returnsListOfText() {
        // Arrange
        when(aboutDAOMock.getText()).thenReturn(Arrays.asList("text"));

        // Act
        List<String> actual = CuT.getText();

        // Assert
        assertEquals(Arrays.asList("text"), actual);
    }
}