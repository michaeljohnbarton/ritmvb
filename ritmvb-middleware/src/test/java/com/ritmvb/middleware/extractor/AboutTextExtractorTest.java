package com.ritmvb.middleware.extractor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AboutTextExtractorTest {

    AboutTextExtractor CuT;

    @Mock
    ResultSet resultSetMock;

    @BeforeEach
    public void setupEach() {
        CuT = new AboutTextExtractor();
    }

    @Test
    public void extractData_resultSetIsEmpty_returnsEmptyList() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(false);

        // Act
        List<String> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void extractData_resultSetHasData_returnsList() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getString("text")).thenReturn("text");

        // Act
        List<String> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(Arrays.asList("text"), actual);
    }
    
}