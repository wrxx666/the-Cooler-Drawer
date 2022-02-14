package com.example.drawer.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Вытаскивает из json ответа сервера токен и сохраняет его для последующего создания запроса
 */
public class JParse {
    public static TokenHolder tokenHolder;
    public static List<HallInfo> hallList;
    public static void tokenParse(String jsonAnswer){
        tokenHolder = new Gson().fromJson(jsonAnswer,TokenHolder.class);
    }
    public static void hallParse(String jsonAnswer){
        System.out.println(jsonAnswer);

        Gson gson = new Gson();

        Type userListType = new TypeToken<ArrayList<HallInfo>>(){}.getType();
        ArrayList<HallInfo> hallArray = gson.fromJson(jsonAnswer,userListType);
        for(HallInfo h : hallArray){
            System.out.println(h.name);
        }
        hallList = hallArray;
    }
}
