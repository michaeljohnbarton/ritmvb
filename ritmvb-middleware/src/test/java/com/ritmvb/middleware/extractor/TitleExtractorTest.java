package com.ritmvb.middleware.extractor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TitleExtractorTest {

    TitleExtractor CuT;

    @Mock
    ResultSet resultSetMock;

    @BeforeEach
    public void setupEach() {
        CuT = new TitleExtractor();
    }

    @Test
    public void extractData_resultSetHasNext_returnsTitle() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getString("title")).thenReturn("title");

        // Act
        String actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals("title", actual);
    }

    @Test
    public void extractData_resultSetDoesntHaveNext_throwsSQLException() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(false);

        // Act/Assert
        String actual = assertThrows(SQLException.class, () -> CuT.extractData(resultSetMock)).getMessage();

        // Assert
        assertEquals("Unable to find results for title.", actual);
    }
}