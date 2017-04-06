package com.seeyon.se.restful;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yangyu on 16/11/17.
 */
@XmlRootElement
public class Message {

    @XmlAttribute
    private String data;

    @XmlAttribute
    private String server;

    @XmlAttribute
    private String engine;

    public Message(){}

    public Message(String data,String server,String engine){
        this.data=data;
        this.server=server;
        this.engine=engine;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
