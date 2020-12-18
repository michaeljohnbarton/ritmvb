package com.ritmvb.middleware.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ritmvb.middleware.model.ContactUsContent;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ContactUsContentExtractor implements ResultSetExtractor<ContactUsContent> {

    @Override
    public ContactUsContent extractData(ResultSet rs) throws SQLException, DataAccessException {
        String text1;
        String email;
        String text2;

        if (rs.next() && rs.getString("type").equals("text1")) {
            text1 = rs.getString("content");
        } else {
            throw new SQLException("Error trying to retrieve text1");
        }

        if (rs.next() && rs.getString("type").equals("email")) {
            email = rs.getString("content");
        } else {
            throw new SQLException("Error trying to retrieve email");
        }

        if (rs.next() && rs.getString("type").equals("text2")) {
            text2 = rs.getString("content");
        } else {
            throw new SQLException("Error trying to retrieve text2");
        }

        return new ContactUsContent(text1, email, text2);

    }

}