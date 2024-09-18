package com.ultimecia.httpserver;
import java.io.IOException;

import com.ultimecia.httpserver.config.Configuration;
import com.ultimecia.httpserver.config.Configurationmanager;
import com.ultimecia.httpserver.core.ServerListenerThread;

public class Httpserver {
    public static void main(String[] args) {
        System.out.println("server starting......");

        Configurationmanager.getinstance().loadConfigurationfile("src/main/resources/http.json");
        Configuration conf = Configurationmanager.getinstance().getcurrentConfiguration();

        System.out.println("using port: "+conf.getPort());
        System.out.println("using webroot: "+ conf.getWebroot());

        try {
            ServerListenerThread ServerListenerThread = new ServerListenerThread(conf.getPort(),conf.getWebroot());
            ServerListenerThread.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
