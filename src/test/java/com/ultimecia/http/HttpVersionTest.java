package com.ultimecia.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class HttpVersionTest {
    @Test
    void getBestCompatibleVersionExactMatch(){
        HttpVersion version=null;
        try {
            version = HttpVersion.getBestCompatibleVersion("HTTP/1.1");
        } catch (BadHttpVersionException e) {
            e.printStackTrace();
            fail();
        }

        assertNotNull(version);
        assertEquals(version,HttpVersion.HTTP_1_1);
    }
}
