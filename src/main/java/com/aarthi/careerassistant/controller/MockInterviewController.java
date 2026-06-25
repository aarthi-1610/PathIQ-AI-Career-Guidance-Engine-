package com.aarthi.careerassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aarthi.careerassistant.dto.MockInterviewRequest;
import com.aarthi.careerassistant.dto.MockInterviewResponse;
import com.aarthi.careerassistant.service.OpenRouterService;

@RestController
@RequestMapping("/api/mock")
public class MockInterviewController {

    @Autowired
    private OpenRouterService openRouterService;

    @PostMapping("/start")
    public MockInterviewResponse startInterview(
            @RequestBody MockInterviewRequest request) {

        String prompt =
                """
                You are a professional interviewer.

                Generate only ONE interview question for %s.

                Return only the question.
                """
                .formatted(request.getRole());

        String response =
                openRouterService.askAI(prompt);

        return new MockInterviewResponse(response);
    }


    	@PostMapping("/evaluate")
    	public MockInterviewResponse evaluateAnswer(
    	        @RequestBody MockInterviewRequest request) {

    		String prompt =
    				"""
    				You are a professional interviewer.

    				Evaluate the answer.

    				STRICT FORMAT:

    				Score: X/10

    				Strengths:
    				- point

    				Improvements:
    				- point

    				NEXT_QUESTION:
    				one new question only

    				Role:
    				%s

    				Answer:
    				%s
    				"""
    				.formatted(
    				request.getRole(),
    				request.getAnswer()
    				);
    	    String response =
    	            openRouterService.askAI(prompt);

    	    return new MockInterviewResponse(response);
    	
    }
}