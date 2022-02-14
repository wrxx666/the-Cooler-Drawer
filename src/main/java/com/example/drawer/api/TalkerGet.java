package com.example.drawer.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Отправляет запрос серверу, возвращает json строку с инфой
 */
public class TalkerGet {
    public static String getRest(String token) throws IOException {
        HttpClient client = new DefaultHttpClient();

        HttpGet request = new HttpGet("http://172.16.5.110:8081/api/restaurants");

        request.addHeader("Authorization",token);

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        String answer = "";
        while ((line = rd.readLine()) != null) {
            answer += line;
        }
        return answer;
    }
}

