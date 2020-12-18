package com.ritmvb.middleware.dao;

import java.util.List;

import com.ritmvb.middleware.extractor.HomeCardsExtractor;
import com.ritmvb.middleware.extractor.TitleExtractor;
import com.ritmvb.middleware.model.HomeCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HomeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getTitle() {
        return jdbcTemplate.query("SELECT title FROM title WHERE page = 'Home'", new TitleExtractor());
    }

    public List<HomeCard> getHomeCards() {
        return jdbcTemplate.query("SELECT title, route, imageURL FROM home_card", new HomeCardsExtractor());
    }
}