package com.ritmvb.middleware.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ritmvb.middleware.model.Officer;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ContactUsOfficersExtractor implements ResultSetExtractor<List<Officer>> {

    @Override
    public List<Officer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Officer> officers = new ArrayList<>();

        while (rs.next()) {
            officers.add(new Officer(rs.getString("first_name") + " " + rs.getString("last_name"),
                    rs.getString("position"), rs.getString("email")));
        }

        return officers;
    }

}