package com.aarthi.careerassistant.controller;

import com.aarthi.careerassistant.dto.ChatRequest;
import com.aarthi.careerassistant.dto.ChatResponse;
import com.aarthi.careerassistant.service.OpenRouterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private OpenRouterService openRouterService;

    @PostMapping
    public ChatResponse chat(
            @RequestBody ChatRequest request) {

        String answer =
                openRouterService.askAI(
                        request.getQuestion());

        return new ChatResponse(answer);
    }
}