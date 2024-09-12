package com.ultimecia.httpserver.config;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ultimecia.httpserver.util.json;

public class Configurationmanager {
    
    private static Configurationmanager myConfigurationmanager;
    private static Configuration myCurrentConfiguration;

    private Configurationmanager(){
    }

    public static Configurationmanager getinstance(){

        if(myConfigurationmanager==null)
            myConfigurationmanager = new Configurationmanager();
        return myConfigurationmanager;
        
    }

    public void loadConfigurationfile(String filePath){
        FileReader fileReader =null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new HttpConfigurationException(e);
        }
        StringBuffer sb = new StringBuffer();
        int i;
        try {
            while( (i =fileReader.read()) !=-1 ){
                sb.append((char)i);
            }
        } catch (IOException e) {
            throw new HttpConfigurationException(e); 
        }
        JsonNode conf;
        try {
            conf = json.parse(sb.toString());
        } catch (IOException e) {
            throw new HttpConfigurationException("error parsing the configuration file",e);
        }
        try {
            myCurrentConfiguration = json.fromJson(conf,Configuration.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("error parsing the configuration file internal",e);
        }

    }

    public Configuration getcurrentConfiguration(){
        if (myCurrentConfiguration==null) {
            throw new HttpConfigurationException("no current exception set");
        }
        return myCurrentConfiguration;
    }   

}
