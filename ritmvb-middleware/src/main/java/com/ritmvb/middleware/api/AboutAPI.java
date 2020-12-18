package com.ritmvb.middleware.api;

import java.util.List;

import com.ritmvb.middleware.MiddlewareApplication;
import com.ritmvb.middleware.dao.AboutDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
public class AboutAPI {

    @Autowired
    AboutDAO aboutDAO;

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/title")
    public String getTitle() {
        return aboutDAO.getTitle();
    }

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/text")
    public List<String> getText() {
        return aboutDAO.getText();
    }

}