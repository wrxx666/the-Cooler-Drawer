package com.example.drawer.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Логинится на сервере и получает json с токеном, возможно будет не только логиниться
 */
public class TalkerPost {
    public static String post(JSONObject user) throws IOException, ParseException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://172.16.5.110:8081/api/authentication/login");

        StringEntity input = new StringEntity(new JSONObject(user).toString());

        post.addHeader("content-type","application/json");
        post.setEntity(input);

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        String tokenLine = "";
        while ((line = rd.readLine()) != null) {
            tokenLine+=line;
            System.out.println(line);
        }

        String result = answerParser(tokenLine);

        JParse.tokenParse(tokenLine);
        return result;
    }
    static String answerParser(String answer) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jojo_lol = new JSONObject();
        Object o = jsonParser.parse(answer);

        if(o instanceof JSONObject){
            jojo_lol = (JSONObject) o;
            System.out.println("complete");
            System.out.println(jojo_lol.toJSONString());
        }

        Object statusCode = jojo_lol.get("statusCode");


        long res = 0;
        if(statusCode instanceof Long){
            res = (Long) statusCode;
        }
        System.out.println(res);
        if(res == 0){
            return "true";
        }
        return ""+statusCode;
    }
}
