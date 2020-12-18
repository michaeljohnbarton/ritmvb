package com.ritmvb.middleware.dao;

import java.util.List;

import com.ritmvb.middleware.extractor.RosterPlayersExtractor;
import com.ritmvb.middleware.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RosterDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getPlayers() {
        return jdbcTemplate.query(
                "SELECT first_name, last_name, number, imageURL, position, year, height, major, hometown FROM player ORDER BY number",
                new RosterPlayersExtractor());
    }

}