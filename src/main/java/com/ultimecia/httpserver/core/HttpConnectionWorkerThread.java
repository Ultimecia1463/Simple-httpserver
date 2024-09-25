package com.ultimecia.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnectionWorkerThread extends Thread {

    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            //reading

            //writing

            String html = "<html><head><title>Simple HTTP Server</title><style>body { font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 0; } .container { max-width: 900px; margin: 0 auto; padding: 20px; background-color: white; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); border-radius: 8px; margin-top: 50px; } h1 { color: #333; text-align: center; margin-bottom: 20px; } p { font-size: 18px; line-height: 1.6; color: #666; } button { display: block; margin: 20px auto; padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; transition: background-color 0.3s; } button:hover { background-color: #45a049; }</style><script>function showAlert() { alert('Hello! This is a test button.'); }</script></head><body><div class='container'><h1>Welcome to My Simple HTTP Server</h1><p>This is a sample web page served by a simple HTTP server built in Java. Click the button below to see a JavaScript alert.</p><button onclick='showAlert()'>Click Me!</button></div></body></html>";

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
            LOGGER.info(" * Connection process finished: ");

        } catch (IOException e) {
            ((org.slf4j.Logger) LOGGER).error("problem with communication"+e);
        }finally{
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                }
            }
            if (outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
