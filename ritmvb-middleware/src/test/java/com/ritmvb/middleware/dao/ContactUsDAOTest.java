package com.ritmvb.middleware.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.extractor.ContactUsContentExtractor;
import com.ritmvb.middleware.extractor.ContactUsOfficersExtractor;
import com.ritmvb.middleware.extractor.TitleExtractor;
import com.ritmvb.middleware.model.ContactUsContent;
import com.ritmvb.middleware.model.Officer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class ContactUsDAOTest {

    @InjectMocks
    ContactUsDAO CuT;

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
    public void getContent_defaultCall_returnsContent() {
        // Arrange
        when(jdbcTemplateMock.query(anyString(), any(ContactUsContentExtractor.class)))
                .thenReturn(new ContactUsContent("text1", "email", "text2"));

        // Act
        ContactUsContent actual = CuT.getContent();

        // Assert
        assertEquals(new ContactUsContent("text1", "email", "text2"), actual);
    }

    @Test
    public void getOfficers_defaultCall_returnsListOfOfficers() {
        // Arrange
        when(jdbcTemplateMock.query(anyString(), any(ContactUsOfficersExtractor.class)))
                .thenReturn(Arrays.asList(new Officer("name", "position", "email")));

        // Act
        List<Officer> actual = CuT.getOfficers();

        // Assert
        assertEquals(Arrays.asList(new Officer("name", "position", "email")), actual);
    }

}