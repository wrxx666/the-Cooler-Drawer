package com.example.drawer.api;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.HashMap;


/**
 * Вытаскивает из json ответа сервера токен и передаёт его для создания запроса
 */
public class JParse {
    public static void tokenParse(String jsonAnswer) throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jojo_lol = new JSONObject();
        Object o = jsonParser.parse(jsonAnswer);

        if(o instanceof JSONObject){
            jojo_lol = (JSONObject) o;
            System.out.println("complete");
            System.out.println(jojo_lol.toJSONString());
        }

        String token = (String) jojo_lol.get("token");
        System.out.println(token);
        HashMap<String,String> getJson = new HashMap<>();
        getJson.put("Authorization",token);
        JSONObject res = new JSONObject(getJson);
        TalkerGet.getRest(token);   //TODO Добавить некий хранитель токена, чтобы можно было делать не только гет запросы
    }
}
