package com.ultimecia.httpserver;
import java.io.IOException;

import org.slf4j.LoggerFactory;

import com.ultimecia.httpserver.config.Configuration;
import com.ultimecia.httpserver.config.Configurationmanager;
import com.ultimecia.httpserver.core.ServerListenerThread;

import ch.qos.logback.classic.Logger;

public class Httpserver {

    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(Httpserver.class);

    public static void main(String[] args) {

        LOGGER.info("server starting......");

        Configurationmanager.getinstance().loadConfigurationfile("src/main/resources/http.json");
        Configuration conf = Configurationmanager.getinstance().getcurrentConfiguration();

        LOGGER.info("using port: "+conf.getPort());
        LOGGER.info("using webroot: "+ conf.getWebroot());

        try {
            ServerListenerThread ServerListenerThread = new ServerListenerThread(conf.getPort(),conf.getWebroot());
            ServerListenerThread.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
