package ru.aka_npou.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.aka_npou.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Data {

    private static boolean isFirst = true;

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void readZipFiles() {
        UnZip app = new UnZip();
        app.unZip();
    }

    public static void readFile(String file) {

        if (!isFirst)
            return;

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        JSONArray array = null;

        try {
            if (file.contains("users")) {
                try {
                    jsonObject = (JSONObject) parser.parse(file);
                } catch (ParseException e) {
                    System.out.println(e);
                }

                array = (JSONArray) jsonObject.get("users");

                User user;
                JSONObject jsOdj;

                for (Object j:array) {
                    user = new User();
                    jsOdj = (JSONObject) j;

                    user.setGender(String.valueOf(jsOdj.get("gender")));
                    user.setBirth_date(Long.valueOf(String.valueOf(jsOdj.get("birth_date"))));
                    user.setLast_name(String.valueOf(jsOdj.get("last_name")));
                    user.setId(Long.valueOf(String.valueOf(jsOdj.get("id"))));
                    user.setFirst_name(String.valueOf(jsOdj.get("first_name")));
                    user.setEmail(String.valueOf(jsOdj.get("email")));

                    addUser(user);

                    isFirst = false;
                    return;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void addUser(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormData(user.toJson()))
                .uri(URI.create("http://localhost:8091/users/new"))
                .setHeader("User-Agent", "Java HL cup") // add request header
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
    }

    private static HttpRequest.BodyPublisher buildFormData(String userJson) {
         //return HttpRequest.BodyPublishers.ofString(URLEncoder.encode(userJson, StandardCharsets.UTF_8));
         return HttpRequest.BodyPublishers.ofString(userJson);
    }

}
