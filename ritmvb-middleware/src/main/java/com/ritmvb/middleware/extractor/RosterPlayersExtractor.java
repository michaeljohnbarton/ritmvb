package com.ritmvb.middleware.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ritmvb.middleware.MiddlewareApplication;
import com.ritmvb.middleware.model.Player;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class RosterPlayersExtractor implements ResultSetExtractor<List<Player>> {

    @Override
    public List<Player> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Player> players = new ArrayList<>();

        while (rs.next()) {
            String name = rs.getString("first_name") + " " + rs.getString("last_name");
            int number = rs.getInt("number");
            String imageURL = MiddlewareApplication.serverURL + "/"
                    + (rs.getString("imageURL") == null ? "person.png" : rs.getString("imageURL"));
            String position = rs.getString("position") == null ? "N/A" : rs.getString("position");
            int year = rs.getInt("year");
            String height = rs.getString("height") == null ? "N/A" : rs.getString("height");
            String major = rs.getString("major") == null ? "N/A" : rs.getString("major");
            String hometown = rs.getString("hometown") == null ? "N/A" : rs.getString("hometown");
            players.add(new Player(name, number, imageURL, position, year, height, major, hometown));
        }

        return players;
    }

}