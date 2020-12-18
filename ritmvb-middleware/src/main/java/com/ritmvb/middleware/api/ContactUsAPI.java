package com.ritmvb.middleware.api;

import java.util.List;

import com.ritmvb.middleware.MiddlewareApplication;
import com.ritmvb.middleware.dao.ContactUsDAO;
import com.ritmvb.middleware.model.ContactUsContent;
import com.ritmvb.middleware.model.Officer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contactUs")
public class ContactUsAPI {

    @Autowired
    ContactUsDAO contactUsDAO;

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/title")
    public String getTitle() {
        return contactUsDAO.getTitle();
    }

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/content")
    public ContactUsContent getContent() {
        return contactUsDAO.getContent();
    }

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/officers")
    public List<Officer> getOfficers() {
        return contactUsDAO.getOfficers();
    }
}