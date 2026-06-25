package com.aarthi.careerassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aarthi.careerassistant.dto.ChatResponse;
import com.aarthi.careerassistant.dto.ResumeRequest;
import com.aarthi.careerassistant.dto.ResumeUploadResponse;
import com.aarthi.careerassistant.service.OpenRouterService;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private OpenRouterService openRouterService;

    @PostMapping("/analyze")
    public ChatResponse analyzeResume(
            @RequestBody ResumeRequest request) {

        String prompt =
                "Analyze this resume and provide:\n"
                + "1. Resume Score out of 100\n"
                + "2. Strengths\n"
                + "3. Weaknesses\n"
                + "4. Suggestions\n\n"
                + request.getResumeText();

        String response =
                openRouterService.askAI(prompt);

        return new ChatResponse(response);
    }
    @PostMapping("/upload")
    public ResumeUploadResponse uploadResume(
            @RequestParam("file") MultipartFile file) {

        try {

            PDDocument document =
                    Loader.loadPDF(file.getBytes());

            PDFTextStripper stripper =
                    new PDFTextStripper();

            String text =
                    stripper.getText(document);

            document.close();

            String prompt =
                    """
                    Analyze this resume and provide:

                    1. Resume Score /100
                    2. Strengths
                    3. Weaknesses
                    4. Suggestions

                    Resume:
                    """ + text;

            String response =
                    openRouterService.askAI(prompt);

            return new ResumeUploadResponse(response);

        } catch(Exception e) {

            return new ResumeUploadResponse(
                    "Error : " + e.getMessage()
            );

        }
    }
}