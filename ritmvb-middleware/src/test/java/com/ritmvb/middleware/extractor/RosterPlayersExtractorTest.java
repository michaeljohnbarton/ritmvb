package com.ritmvb.middleware.extractor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.MiddlewareApplication;
import com.ritmvb.middleware.model.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RosterPlayersExtractorTest {

    RosterPlayersExtractor CuT;

    @Mock
    ResultSet resultSetMock;

    @BeforeEach
    public void setupEach() {
        CuT = new RosterPlayersExtractor();
    }

    @Test
    public void extractData_resultSetIsEmpty_returnsEmptyList() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(false);

        // Act
        List<Player> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void extractData_imageURLIsNull_returnsPlayerWithPersonPNGImageURL() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getInt(anyString())).thenReturn(0);
        when(resultSetMock.getString(anyString())).thenReturn("notNull");
        when(resultSetMock.getString("imageURL")).thenReturn(null);

        // Act
        List<Player> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(Arrays.asList(new Player("notNull notNull", 0, MiddlewareApplication.serverURL + "/person.png",
                "notNull", 0, "notNull", "notNull", "notNull")), actual);

    }

    @Test
    public void extractData_positionIsNull_returnsPlayerWithNAPosition() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getInt(anyString())).thenReturn(0);
        when(resultSetMock.getString(anyString())).thenReturn("notNull");
        when(resultSetMock.getString("position")).thenReturn(null);

        // Act
        List<Player> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(Arrays.asList(new Player("notNull notNull", 0, MiddlewareApplication.serverURL + "/notNull", "N/A",
                0, "notNull", "notNull", "notNull")), actual);

    }

    @Test
    public void extractData_heightIsNull_returnsPlayerWithNAHeight() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getInt(anyString())).thenReturn(0);
        when(resultSetMock.getString(anyString())).thenReturn("notNull");
        when(resultSetMock.getString("height")).thenReturn(null);

        // Act
        List<Player> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(Arrays.asList(new Player("notNull notNull", 0, MiddlewareApplication.serverURL + "/notNull",
                "notNull", 0, "N/A", "notNull", "notNull")), actual);

    }

    @Test
    public void extractData_majorIsNull_returnsPlayerWithNAMajor() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getInt(anyString())).thenReturn(0);
        when(resultSetMock.getString(anyString())).thenReturn("notNull");
        when(resultSetMock.getString("major")).thenReturn(null);

        // Act
        List<Player> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(Arrays.asList(new Player("notNull notNull", 0, MiddlewareApplication.serverURL + "/notNull",
                "notNull", 0, "notNull", "N/A", "notNull")), actual);

    }

    @Test
    public void extractData_hometownIsNull_returnsPlayerWithNAHometown() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getInt(anyString())).thenReturn(0);
        when(resultSetMock.getString(anyString())).thenReturn("notNull");
        when(resultSetMock.getString("hometown")).thenReturn(null);

        // Act
        List<Player> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(Arrays.asList(new Player("notNull notNull", 0, MiddlewareApplication.serverURL + "/notNull",
                "notNull", 0, "notNull", "notNull", "N/A")), actual);

    }

    @Test
    public void extractData_noResultsAreNull_returnsPlayer() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getInt("number")).thenReturn(0);
        when(resultSetMock.getInt("year")).thenReturn(1);
        when(resultSetMock.getString("first_name")).thenReturn("first_name");
        when(resultSetMock.getString("last_name")).thenReturn("last_name");
        when(resultSetMock.getString("imageURL")).thenReturn("imageURL");
        when(resultSetMock.getString("position")).thenReturn("position");
        when(resultSetMock.getString("height")).thenReturn("height");
        when(resultSetMock.getString("major")).thenReturn("major");
        when(resultSetMock.getString("hometown")).thenReturn("hometown");

        // Act
        List<Player> actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(Arrays.asList(new Player("first_name last_name", 0, MiddlewareApplication.serverURL + "/imageURL",
                "position", 1, "height", "major", "hometown")), actual);

    }

}