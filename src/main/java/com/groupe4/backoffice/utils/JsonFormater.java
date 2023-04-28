package com.groupe4.backoffice.utils;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import com.mysql.cj.xdevapi.JsonString;
import com.mysql.cj.xdevapi.JsonValue;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class JsonFormater {
    public static String arraysStringToJsonString(List<String> strings) {
        JsonArray jsonArray = new JsonArray();
        for (String string: strings) {
            jsonArray.addValue(new JsonString().setValue(string));
        }
        return jsonArray.toString();
    }

    public static List<String> JsonToListString(String json) {
        List<String> list = new ArrayList<>();

        StringReader stringReader = new StringReader(json);
        try {
            for (JsonValue jsonValue : JsonParser.parseArray(stringReader)) {
                list.add(String.valueOf(jsonValue).replace("\"", ""));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return list;
    }
}
