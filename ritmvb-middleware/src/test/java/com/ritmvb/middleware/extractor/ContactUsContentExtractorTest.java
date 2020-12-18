package com.ritmvb.middleware.extractor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ritmvb.middleware.model.ContactUsContent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContactUsContentExtractorTest {

    ContactUsContentExtractor CuT;

    @Mock
    ResultSet resultSetMock;

    @BeforeEach
    public void setupEach() {
        CuT = new ContactUsContentExtractor();
    }

    @Test
    public void extractData_resultSetIsEmpty_throwsSQLException() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(false);

        // Act/Assert
        String actual = assertThrows(SQLException.class, () -> CuT.extractData(resultSetMock)).getMessage();

        // Assert
        assertEquals("Error trying to retrieve text1", actual);
    }

    @Test
    public void extractData_firstItemInResultSetNotText1_throwsSQLException() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getString("type")).thenReturn("notText1");

        // Act/Assert
        String actual = assertThrows(SQLException.class, () -> CuT.extractData(resultSetMock)).getMessage();

        // Assert
        assertEquals("Error trying to retrieve text1", actual);
    }

    @Test
    public void extractData_onlyOneItemInResultSet_throwsSQLException() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, false);
        when(resultSetMock.getString("type")).thenReturn("text1");

        // Act/Assert
        String actual = assertThrows(SQLException.class, () -> CuT.extractData(resultSetMock)).getMessage();

        // Assert
        assertEquals("Error trying to retrieve email", actual);
    }

    @Test
    public void extractData_secondItemInResultSetNotEmail_throwsSQLException() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, true, false);
        when(resultSetMock.getString("type")).thenReturn("text1", "notEmail");

        // Act/Assert
        String actual = assertThrows(SQLException.class, () -> CuT.extractData(resultSetMock)).getMessage();

        // Assert
        assertEquals("Error trying to retrieve email", actual);
    }

    @Test
    public void extractData_onlyTwoItemsInResultSet_throwsSQLException() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, true, false);
        when(resultSetMock.getString("type")).thenReturn("text1", "email");

        // Act/Assert
        String actual = assertThrows(SQLException.class, () -> CuT.extractData(resultSetMock)).getMessage();

        // Assert
        assertEquals("Error trying to retrieve text2", actual);
    }

    @Test
    public void extractData_thirdItemInResultSetNotText2_throwsSQLException() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, true, true, false);
        when(resultSetMock.getString("type")).thenReturn("text1", "email", "notText2");

        // Act/Assert
        String actual = assertThrows(SQLException.class, () -> CuT.extractData(resultSetMock)).getMessage();

        // Assert
        assertEquals("Error trying to retrieve text2", actual);
    }

    @Test
    public void extractData_resultSetHasAllCorrectData_returnsContactUs() throws SQLException {
        // Arrange
        when(resultSetMock.next()).thenReturn(true, true, true, false);
        when(resultSetMock.getString("type")).thenReturn("text1", "email", "text2");
        when(resultSetMock.getString("content")).thenReturn("aText1", "anEmail", "aText2");

        // Act
        ContactUsContent actual = CuT.extractData(resultSetMock);

        // Assert
        assertEquals(new ContactUsContent("aText1", "anEmail", "aText2"), actual);
    }

}