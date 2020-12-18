package com.ritmvb.middleware.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.extractor.HomeCardsExtractor;
import com.ritmvb.middleware.extractor.TitleExtractor;
import com.ritmvb.middleware.model.HomeCard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class HomeDAOTest {

    @InjectMocks
    HomeDAO CuT;

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @Test
    public void getTitle_defaultCall_returnsTitle() {
        // Arrange
        when(jdbcTemplateMock.query(anyString(), any(TitleExtractor.class))).thenReturn("title");

        // Act
        String actual = CuT.getTitle();

        // Assert
        assertEquals("title", actual);
    }

    @Test
    public void getHomeCards_defaultCall_returnsListOfHomeCards() {
        // Arrange
        when(jdbcTemplateMock.query(anyString(), any(HomeCardsExtractor.class)))
                .thenReturn(Arrays.asList(new HomeCard("title", "route", "imageURL")));

        // Act
        List<HomeCard> actual = CuT.getHomeCards();

        // Assert
        assertEquals(Arrays.asList(new HomeCard("title", "route", "imageURL")), actual);
    }
}