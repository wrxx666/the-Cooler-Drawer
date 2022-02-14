package com.example.drawer.control.logic;

import com.example.drawer.api.TalkerPost;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class SignIn {
    public static String jsonSign(String login, String password) throws IOException, ParseException {
        HashMap<String,String> userMap = new HashMap<>();
        userMap.put("login",login);
        userMap.put("password",password);
        JSONObject user = new JSONObject(userMap);
        String answer = TalkerPost.post(user);
        return answer;
    }
}
