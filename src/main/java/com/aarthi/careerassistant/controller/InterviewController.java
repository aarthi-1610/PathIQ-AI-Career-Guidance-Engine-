package com.aarthi.careerassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aarthi.careerassistant.dto.ChatResponse;
import com.aarthi.careerassistant.dto.InterviewRequest;
import com.aarthi.careerassistant.service.OpenRouterService;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    private OpenRouterService openRouterService;

    @PostMapping("/questions")
    public ChatResponse generateQuestions(
            @RequestBody InterviewRequest request) {

        String prompt =
                "Generate 10 "
                + request.getLevel()
                + " interview questions for "
                + request.getTechnology()
                + ". Return only questions.";

        String response =
                openRouterService.askAI(prompt);

        return new ChatResponse(response);
    }
}