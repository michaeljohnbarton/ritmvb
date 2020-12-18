package com.ritmvb.middleware.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.ritmvb.middleware.extractor.RosterPlayersExtractor;
import com.ritmvb.middleware.model.Player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class RosterDAOTest {
    
    @InjectMocks
    RosterDAO CuT;

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @Test
    public void getPlayers_defaultCall_returnsListOfPlayers() {
        // Arrange
        when(jdbcTemplateMock.query(anyString(), any(RosterPlayersExtractor.class))).thenReturn(Arrays.asList(new Player("name", 0, "imageURL", "position", 1, "height", "major", "hometown")));

        // Act
        List<Player> actual = CuT.getPlayers();

        // Assert
        assertEquals(Arrays.asList(new Player("name", 0, "imageURL", "position", 1, "height", "major", "hometown")), actual);
    }

}