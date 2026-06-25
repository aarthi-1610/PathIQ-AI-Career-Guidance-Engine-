package com.aarthi.careerassistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/chat-ui")
    public String chatUI() {
        return "chat";
    }

    @GetMapping("/resume-ui")
    public String resumeUI() {
        return "resume";
    }

    @GetMapping("/interview-ui")
    public String interviewUI() {
        return "interview";
    }

    @GetMapping("/roadmap-ui")
    public String roadmapUI() {
        return "roadmap";
    }
    
    @GetMapping("/mock-interview-ui")
    public String mockInterviewUI() {
        return "mock-interview";
    }
}