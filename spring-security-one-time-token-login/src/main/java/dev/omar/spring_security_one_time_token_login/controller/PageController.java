package dev.omar.spring_security_one_time_token_login.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("/ott/sent")
    public String ottSent() {
        return "sent";
    }

}