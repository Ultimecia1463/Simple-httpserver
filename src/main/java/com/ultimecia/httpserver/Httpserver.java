package com.ultimecia.httpserver;
import com.ultimecia.httpserver.config.Configurationmanager;

/*
 * 
 * driver class for the httpserver
 * 
 */

public class Httpserver {
    public static void main(String[] args) {
        System.out.println("server starting......");
        Configurationmanager.getinstance().loadConfigurationfile("src/main/resources/http.json");
    }
}
