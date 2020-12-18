package com.ritmvb.middleware.api;

import java.util.List;

import com.ritmvb.middleware.MiddlewareApplication;
import com.ritmvb.middleware.dao.HomeDAO;
import com.ritmvb.middleware.model.HomeCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeAPI {

    @Autowired
    HomeDAO homeDAO;

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/title")
    public String getTitle() {
        return homeDAO.getTitle();
    }

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/homeCards")
    public List<HomeCard> getHomeCards() {
        return homeDAO.getHomeCards();
    }
}