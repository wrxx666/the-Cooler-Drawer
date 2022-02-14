package com.example.drawer.control.logic;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class UserParserToJSON {
    public static JSONObject jsonSign(String login, String password){
        HashMap<String,String> userMap = new HashMap<>();
        userMap.put("login",login);
        userMap.put("password",password);
        JSONObject user = new JSONObject(userMap);
        return user;
    }
}
