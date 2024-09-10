package com.ultimecia.httpserver.config;

public class Configurationmanager {
    
    private static Configurationmanager myConfigurationmanager;
    private static Configuration mycurrentConfiguration;

    private Configurationmanager(){
    }

    public static Configurationmanager getinstance(){

        if(myConfigurationmanager==null)
            myConfigurationmanager = new Configurationmanager();
        return myConfigurationmanager;
        
    }

    public void loadConfigurationfile(String filepatn){

    }

    public void getcurrentConfiguration(){

    }   

}
