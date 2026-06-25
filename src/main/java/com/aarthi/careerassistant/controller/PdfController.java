package com.aarthi.careerassistant.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @PostMapping("/download")
    public ResponseEntity<byte[]> downloadPdf(
            @RequestBody String content) {

        try {

            Document document =
                    new Document();

            ByteArrayOutputStream output =
                    new ByteArrayOutputStream();

            PdfWriter.getInstance(
                    document,
                    output
            );

            document.open();

            document.add(
                    new Paragraph(
                            "AI Resume Analysis Report"
                    )
            );

            document.add(
                    new Paragraph(" ")
            );

            document.add(
                    new Paragraph(content)
            );

            document.close();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=resume-analysis.pdf"
                    )
                    .contentType(
                            MediaType.APPLICATION_PDF
                    )
                    .body(output.toByteArray());

        } catch(Exception e) {

            return ResponseEntity.badRequest()
                    .build();

        }
    }
}