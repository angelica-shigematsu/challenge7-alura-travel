package br.com.turism.viagemja.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class CreateTextDescriptionOpenAI {
    public static String showTextDescription(String place) {
        String apiKey = "";

        String prompt = "Faça um resumo sobre" + place + "enfatizando o porque este lugar é incrível. " +
                "Utilize uma linguagem informal e no máximo um parágrafo e até 100 caracteres.";

        try {
            String text = generateText(apiKey, prompt);
           return  text;
        } catch (Exception e) {
            return "";
        }
    }

    public static String generateText(String apiKey, String prompt) throws Exception {
        String endpoint = "https://api.openai.com/v1/completions";
        String model = "gpt-3.5-turbo"; // Você pode ajustar o modelo conforme necessário

        HttpClient httpClient = HttpClient.newHttpClient();

        Map<Object, Object> data = new HashMap<>();
        data.put("prompt", prompt);
        data.put("max_tokens", 150); // Ajuste conforme necessário

        String jsonInput = String.format("{\"model\": \"%s\", \"prompt\": \"%s\", \"max_tokens\": 150}", model, prompt);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonInput))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            return response.body();
        }
    }
}
