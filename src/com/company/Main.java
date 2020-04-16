package com.company;

import Database.Database;
import Serverside.Communication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {

    static String filepath = "tests/";

    static Database database;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080);
            Database database = new Database("users.db")){

            System.out.println("Server started!\nDatabase started!");

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            while (true) {
                Communication communication = new Communication(serverSocket);
                System.out.println("Connected");

                new Thread(() -> {
                    try {
                        String rq = communication.readLine();

                        if (rq != null) {



                            rq = URLDecoder.decode(rq.substring(5,rq.length()-9));
                            System.out.println(rq);

                            URLData urlData = parseURL(rq);

                            if (urlData.request.equals("register"))



                        }
                        communication.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }

    static void addFile(String username, String password, String filename, String file) {
        File.write(filepath + filename + ".json", file);
        database.test.add(username, password, filename);
    }

    static URLData parseURL(String url) {
        String request = url.substring(0,url.indexOf("?"));

        String[] b = url.substring(url.indexOf("?")).split("&");
        HashMap<String, String> hashMap = new HashMap();
        String[] c;
        for (int i = 0; i < b.length;i++) {
            c = b[i].split("=");
            hashMap.put(c[0], c[1]);
        }

        return new URLData(request, hashMap);
    }
}

class URLData{
    String request;
    HashMap hashMap;

    URLData(String request, HashMap hashMap) {
        this.request = request;
        this.hashMap = hashMap;
    }

    @Override
    public String toString() {
        return request + " " + hashMap;
    }
}


