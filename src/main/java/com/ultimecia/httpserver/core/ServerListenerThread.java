package com.ultimecia.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread{

    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    public ServerListenerThread(int port ,String webroot) throws IOException{
        this.port=port;
        this.webroot=webroot;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run(){
        try {
            
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //reading



            //writing
            String html="<html> <head> <title> simple http server </title> <body> <h1>hello world</h1> </body> </head> </html>";

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