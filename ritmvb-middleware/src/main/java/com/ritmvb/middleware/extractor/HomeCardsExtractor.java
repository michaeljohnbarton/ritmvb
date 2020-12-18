package com.ritmvb.middleware.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ritmvb.middleware.MiddlewareApplication;
import com.ritmvb.middleware.model.HomeCard;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class HomeCardsExtractor implements ResultSetExtractor<List<HomeCard>> {

    @Override
    public List<HomeCard> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<HomeCard> homeCards = new ArrayList<>();

        while (rs.next()) {
            homeCards.add(new HomeCard(rs.getString("title"), rs.getString("route"),
                    MiddlewareApplication.serverURL + "/" + rs.getString("imageURL")));
        }

        return homeCards;
    }

}