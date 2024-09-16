package com.ultimecia.httpserver;
import com.ultimecia.httpserver.config.Configuration;
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
        Configuration conf = Configurationmanager.getinstance().getcurrentConfiguration();

        System.out.println("using port: "+conf.getPort());
        System.out.println("using webroot: "+ conf.getWebroot());
    }
}
