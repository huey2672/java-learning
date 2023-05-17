package com.huey.learning.java.feature.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientPostSample {

    public static void main(String[] args) throws Exception {

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.
                ofString("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}");

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(bodyPublisher)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(postRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        HttpHeaders headers = response.headers();
        String body = response.body();

    }

}
