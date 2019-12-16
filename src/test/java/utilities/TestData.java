package utilities;

import base.BaseTest;
import base.Credentials;
import com.google.gson.Gson;

import java.util.HashMap;

public class TestData extends BaseTest {
    public String getBoardTestData(String boardName){
        HashMap<String, String> jsonMap = new HashMap<>();
        jsonMap.put("name", boardName);
        jsonMap.put("key", key);
        jsonMap.put("token", token);

        return new Gson().toJson(jsonMap);
    }

    public String getLabelTestData(String boardName, String color){
        HashMap<String, String> jsonMap = new HashMap<>();
        jsonMap.put("name", boardName);
        jsonMap.put("color", color);
        jsonMap.put("key", key);
        jsonMap.put("token", token);

        return new Gson().toJson(jsonMap);
    }
}
