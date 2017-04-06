package com.seeyon.se.restful;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by yangyu on 16/11/17.
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on

    public static String address;

    public static ClassPathXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("/consumer.xml");
        context.start();
    }
    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args){
        if (args.length>0)
            address = args[0];
        else
            address = "localhost:8080";
        String BASE_URI = "http://"+address+"/se/";
        // create a resource config that scans for JAX-RS resources and providers
        // in my.restful package
        final ResourceConfig rc = new ResourceConfig().packages("com.seeyon.se.restful");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

        String str;
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        //获取键盘输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true)
            {
                str = input.readLine();
                System.out.println("退出请使用：exit");
                if ("exit".equals(str))
                    break;
            }
            server.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
