package com.example.drawer.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Вытаскивает из json ответа сервера токен и передаёт его для создания запроса
 */
public class JParse {
    public static void tokenParse(String jsonAnswer) throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        JSONObject answerOwner = (JSONObject) jsonParser.parse(jsonAnswer);

        String token = (String) answerOwner.get("token");

        //HashMap<String,String> getJson = new HashMap<>();
        answerOwner.remove("token");
        answerOwner.put("Authorization",token);

        TalkerGet.getRest(token);//TODO Добавить некий хранитель токена, чтобы можно было делать не только гет запросы

        FileWriter fw = new FileWriter("./src/main/java/com/example/drawer/api/UserData.json");   //Записывает в жесон
        fw.write(answerOwner.toJSONString());
        fw.close();


        FileReader reader = new FileReader("./src/main/java/com/example/drawer/api/UserData.json"); //читает из жесона
        BufferedReader br = new BufferedReader(reader);
        String buffer = "";
        while(br.ready()){
            buffer += br.readLine();
        }
    }
}
