package com.ritmvb.middleware.dao;

import java.util.List;

import com.ritmvb.middleware.extractor.AboutTextExtractor;
import com.ritmvb.middleware.extractor.TitleExtractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AboutDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getTitle() {
        return jdbcTemplate.query("SELECT title FROM title WHERE page = 'About'", new TitleExtractor());
    }

    public List<String> getText() {
        return jdbcTemplate.query("SELECT text FROM about_text", new AboutTextExtractor());
    }

}