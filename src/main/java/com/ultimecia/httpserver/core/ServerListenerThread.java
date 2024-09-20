package com.ultimecia.httpserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class ServerListenerThread extends Thread{

    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(ServerListenerThread.class);

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

            while(serverSocket.isBound() && !serverSocket.isClosed()){
            
                Socket socket = serverSocket.accept();

                LOGGER.info(" * connection accepted:"+socket.getInetAddress());

                HttpConnectionWorkerThread workerThread = new HttpConnectionWorkerThread(socket);
                workerThread.start();

            }    
            //serverSocket.close();

        } catch (IOException e) {
            ((org.slf4j.Logger) LOGGER).error("problem with setting socket"+e);
        }finally{
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}