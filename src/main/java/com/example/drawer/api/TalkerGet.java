package com.example.drawer.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Отправляет запрос серверу
 */
public class TalkerGet {
    public static void getRest(String token) throws IOException {
        HttpClient client = new DefaultHttpClient();

        HttpGet request = new HttpGet("http://172.16.5.110:8081/api/restaurants");

        request.addHeader("Authorization",token);

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));

        String line = "";

        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }
}

