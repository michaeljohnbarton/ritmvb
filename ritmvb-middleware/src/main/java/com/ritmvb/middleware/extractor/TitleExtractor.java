package com.ritmvb.middleware.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TitleExtractor implements ResultSetExtractor<String> {

    @Override
    public String extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next())
            return rs.getString("title");
        throw new SQLException("Unable to find results for title.");
    }

}