package com.ritmvb.middleware.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.extractor.AboutTextExtractor;
import com.ritmvb.middleware.extractor.TitleExtractor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class AboutDAOTest {

    @InjectMocks
    AboutDAO CuT;

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
    public void getText_defaultCall_returnsListOfText() {
        // Arrange
        when(jdbcTemplateMock.query(anyString(), any(AboutTextExtractor.class))).thenReturn(Arrays.asList("text"));

        // Act
        List<String> actual = CuT.getText();

        // Assert
        assertEquals(Arrays.asList("text"), actual);
    }

}