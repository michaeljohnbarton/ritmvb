package com.ritmvb.middleware.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.dao.HomeDAO;
import com.ritmvb.middleware.model.HomeCard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HomeAPITest {
    
    @InjectMocks
    HomeAPI CuT;

    @Mock
    HomeDAO homeDAOMock;

    @Test
    public void getTitle_defaultCall_returnsTitle() {
        // Arrange
        when(homeDAOMock.getTitle()).thenReturn("title");

        // Act
        String actual = CuT.getTitle();

        // Assert
        assertEquals("title", actual);
    }

    @Test
    public void getHomeCards_defaultCall_returnsListOfHomeCards() {
        // Arrange
        when(homeDAOMock.getHomeCards())
                .thenReturn(Arrays.asList(new HomeCard("title", "route", "imageURL")));

        // Act
        List<HomeCard> actual = CuT.getHomeCards();

        // Assert
        assertEquals(Arrays.asList(new HomeCard("title", "route", "imageURL")), actual);
    }
}