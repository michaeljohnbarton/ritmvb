package com.ritmvb.middleware.dao;

import java.util.List;

import com.ritmvb.middleware.extractor.ContactUsContentExtractor;
import com.ritmvb.middleware.extractor.ContactUsOfficersExtractor;
import com.ritmvb.middleware.extractor.TitleExtractor;
import com.ritmvb.middleware.model.ContactUsContent;
import com.ritmvb.middleware.model.Officer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContactUsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getTitle() {
        return jdbcTemplate.query("SELECT title FROM title WHERE page = 'Contact Us'", new TitleExtractor());
    }

    public ContactUsContent getContent() {
        return jdbcTemplate.query("SELECT type, content FROM contact_us_content", new ContactUsContentExtractor());
    }

    public List<Officer> getOfficers() {
        return jdbcTemplate.query(
                "SELECT p.first_name, p.last_name, o.position, p.email FROM player p JOIN officer o ON p.id = o.player_id",
                new ContactUsOfficersExtractor());
    }

}