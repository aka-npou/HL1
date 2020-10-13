package ru.aka_npou.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.aka_npou.exception.Exception400;
import ru.aka_npou.exception.Exception404;
import ru.aka_npou.model.User;

public class Util {

    public static User getUser(String body) throws Exception400, Exception404 {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) parser.parse(body);
        } catch (ParseException e) {
            //responseStatus = "400 Bad Request";
            throw new Exception400();
        }

        if (jsonObject.keySet().size() != 6) {
            //responseStatus = "400 Bad Request";
            throw new Exception400();
        }

        /*for (Object key : jsonObject.keySet()) {
            String keyStr = (String) key;
            Object keyvalue = jsonObject.get(keyStr);
            if (keyvalue == null) {
                //responseStatus = "400 Bad Request";
                throw new Exception400();
            }
        }*/

        User user = new User();

        for (Object key : jsonObject.keySet()) {
            String keyStr = (String) key;
            Object keyValue = jsonObject.get(keyStr);
            try {
                user.setKeyValue(keyStr, keyValue);
            } catch (Exception e) {
                System.out.println("========================================new u "+ keyStr + " " + keyValue);
                System.out.println(body);
                //responseStatus = "400 Bad Request";
                throw new Exception400();
            }

        }

        return user;
    }
}
