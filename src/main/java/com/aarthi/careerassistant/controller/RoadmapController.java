package com.aarthi.careerassistant.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aarthi.careerassistant.dto.RoadmapRequest;
import com.aarthi.careerassistant.service.OpenRouterService;

@RestController
@RequestMapping("/api/roadmap")
public class RoadmapController {

    @Autowired
    private OpenRouterService openRouterService;

    @PostMapping("/generate")
    public Map<String,String> generateRoadmap(
            @RequestBody RoadmapRequest request) {

    	String prompt =
    			"""
    			Create a professional 6 month roadmap for %s.

    			Format exactly like:

    			## Month 1
    			- Topic 1
    			- Topic 2
    			- Topic 3

    			## Month 2
    			- Topic 1
    			- Topic 2

    			## Month 3
    			- Topic 1
    			- Topic 2

    			Continue until Month 6.

    			Return only roadmap.
    			""".formatted(request.getCareer());

        String response =
                openRouterService.askAI(prompt);

        return Map.of(
                "roadmap",
                response
        );
    }
}