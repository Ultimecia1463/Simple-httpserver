package com.ultimecia.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class HttpConnectionWorkerThread extends Thread {

    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket){
        this.socket=socket;
    }


    @Override
    public void run(){
        try {
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

            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            LOGGER.info(" * Connection process finished: ");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
