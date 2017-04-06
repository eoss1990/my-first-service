package com.seeyon.se.restful;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by yangyu on 16/11/17.
 */
@ApplicationPath("/se/*")
public class JsonResourceConfig extends ResourceConfig {
    public JsonResourceConfig(){
        register(MyRestful.class);
    }
}
