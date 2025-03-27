package com.example.mysql;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpUtils {
    public static String post(String urlString, String postData) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        OutputStream os = conn.getOutputStream();
        os.write(postData.getBytes());
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return new Scanner(conn.getInputStream()).useDelimiter("\\A").next();
        } else {
            return null;
        }
    }
}