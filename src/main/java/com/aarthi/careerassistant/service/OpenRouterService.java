package com.aarthi.careerassistant.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OpenRouterService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public OpenRouterService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String askAI(String question) {

        String url = "https://openrouter.ai/api/v1/chat/completions";

        Map<String, Object> requestBody =
                Map.of(
                        "model", "deepseek/deepseek-chat-v3-0324",
                        "messages",
                        List.of(
                                Map.of(
                                        "role", "user",
                                        "content", question
                                )
                        )
                );

        try {

            Map response =
                    webClient.post()
                            .uri(url)
                            .header(HttpHeaders.AUTHORIZATION,
                                    "Bearer " + apiKey)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(requestBody)
                            .retrieve()
                            .bodyToMono(Map.class)
                            .block();

            List choices =
                    (List) response.get("choices");

            Map choice =
                    (Map) choices.get(0);

            Map message =
                    (Map) choice.get("message");

            return message.get("content").toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }
    }
}