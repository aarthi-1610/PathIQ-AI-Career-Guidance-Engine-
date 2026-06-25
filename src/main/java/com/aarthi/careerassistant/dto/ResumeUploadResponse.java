package com.aarthi.careerassistant.dto;

public class ResumeUploadResponse {

    private String analysis;

    public ResumeUploadResponse(String analysis) {
        this.analysis = analysis;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}