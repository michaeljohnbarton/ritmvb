package com.ritmvb.middleware.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class AboutTextExtractor implements ResultSetExtractor<List<String>> {

    @Override
    public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<String> text = new ArrayList<>();

        while (rs.next()) {
            text.add(rs.getString("text"));
        }

        return text;
    }

}