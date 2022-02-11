package com.example.drawer.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Логинится на сервере и получает json с токеном, возможно будет не только логиниться
 */
public class TalkerPost {
    public static void post(String login, String password) throws IOException, ParseException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://172.16.5.110:8081/api/authentication/login");

        HashMap<String, String> json = new HashMap<>();
        json.put("login","admin");
        json.put("password","admin");

        StringEntity input = new StringEntity(new JSONObject(json).toString());

        post.addHeader("content-type","application/json");
        post.setEntity(input);

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        String tokenLine = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            tokenLine+=line;
        }
        System.out.println(tokenLine);
        JParse.tokenParse(tokenLine);
    }
}
