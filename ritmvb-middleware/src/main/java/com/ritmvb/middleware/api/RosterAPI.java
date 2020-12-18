package com.ritmvb.middleware.api;

import java.util.List;

import com.ritmvb.middleware.MiddlewareApplication;
import com.ritmvb.middleware.dao.RosterDAO;
import com.ritmvb.middleware.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roster")
public class RosterAPI {

    @Autowired
    RosterDAO rosterDAO;

    @CrossOrigin(origins = MiddlewareApplication.clientURL)
    @RequestMapping("/players")
    public List<Player> getPlayers() {
        return rosterDAO.getPlayers();
    }

}