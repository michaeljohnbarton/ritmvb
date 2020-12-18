package com.ritmvb.middleware.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.dao.RosterDAO;
import com.ritmvb.middleware.model.Player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RosterAPITest {

    @InjectMocks
    RosterAPI CuT;

    @Mock
    RosterDAO rosterDAOMock;

    @Test
    public void getPlayers_defaultCall_returnsListOfPlayers() {
        // Arrange
        when(rosterDAOMock.getPlayers()).thenReturn(Arrays.asList(new Player("name", 0, "imageURL", "position", 1, "height", "major", "hometown")));

        // Act
        List<Player> actual = CuT.getPlayers();

        // Assert
        assertEquals(Arrays.asList(new Player("name", 0, "imageURL", "position", 1, "height", "major", "hometown")), actual);
    }
    
}