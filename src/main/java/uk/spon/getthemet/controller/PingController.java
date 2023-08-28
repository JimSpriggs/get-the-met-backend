package uk.spon.getthemet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import uk.spon.getthemet.service.MetrolinkStationService;

import java.util.HashMap;
import java.util.Map;


@RestController
@EnableWebMvc
public class PingController {

    @Autowired
    private MetrolinkStationService metrolinkStationService;

    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public Map<String, String> ping() {
        Map<String, String> pong = new HashMap<>();
        pong.put("pong", "Hello, World!  Welcome to " + metrolinkStationService.name());
        return pong;
    }
}
