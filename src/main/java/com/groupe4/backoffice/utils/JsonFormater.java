package com.groupe4.backoffice.utils;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonString;

import java.util.List;

public class JsonFormater {
    public static String arraysStringToJsonString(List<String> strings) {
        JsonArray jsonArray = new JsonArray();
        for (String string: strings) {
            jsonArray.addValue(new JsonString().setValue(string));
        }
        return jsonArray.toString();
    }
}
