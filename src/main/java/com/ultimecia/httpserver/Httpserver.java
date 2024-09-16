package com.ultimecia.httpserver;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.ultimecia.httpserver.config.Configuration;
import com.ultimecia.httpserver.config.Configurationmanager;

public class Httpserver {
    public static void main(String[] args) {
        System.out.println("server starting......");

        Configurationmanager.getinstance().loadConfigurationfile("src/main/resources/http.json");
        Configuration conf = Configurationmanager.getinstance().getcurrentConfiguration();

        System.out.println("using port: "+conf.getPort());
        System.out.println("using webroot: "+ conf.getWebroot());

        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //reading



            //writing
            String html="<html> <head> <title> simple http server </title> <body> <h1>page</h1> </body> </head> </html>";

            final String CRLF="\r\n"; // 13 , 10  ASCII

            String response = 
                "HTTP/1.1 200 ok"       +     //status line : HTTP_ver RESPONSE_CODE RESPONSE_MSG
                CRLF                    +
                "Content-length: "      +     // HEADER
                html.getBytes().length  +
                CRLF+CRLF               +
                html                    +
                CRLF+CRLF               ;

            outputStream.write(response.getBytes());
            

            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
