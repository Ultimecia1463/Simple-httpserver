package com.ultimecia.httpserver.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class json {
    
    private static ObjectMapper myObjectMapper = defaultObjectMapper();

    private  static ObjectMapper defaultObjectMapper(){

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

}
