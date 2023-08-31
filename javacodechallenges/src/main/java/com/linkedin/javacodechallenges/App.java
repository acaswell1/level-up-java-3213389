package com.linkedin.javacodechallenges;

import java.io.*;
import java.net.*;
import org.json.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        StringBuilder dj_stringbldr = new StringBuilder();
        String dad_joke= "";

        try {
            URL dj_url = new URL("https://icanhazdadjoke.com");
            HttpURLConnection dj_conn = (HttpURLConnection) dj_url.openConnection();
            dj_conn.setRequestProperty("Accept", "application/json");
            dj_conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(dj_conn.getInputStream()))) {
                String response = "";
                while ((response = reader.readLine()) != null) {
                    dj_stringbldr.append(response);
                }
                JSONObject dj_json = new JSONObject(dj_stringbldr.toString());
                dad_joke = dj_json.getString("joke");
            } catch (Exception e) {
                e.printStackTrace();
            }
            dj_conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(dad_joke);
    }
}
