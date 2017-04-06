package com.seeyon.se.restful;

import com.alibaba.fastjson.JSON;
import com.myfirstdubbo.DemoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by yangyu on 16/11/14.
 */
@Path("restful")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
public class MyRestful {

    @GET
    @Path("service/{key}")
    public String execService(@PathParam("key") String key){

        DemoService demoService = (DemoService)Main.context.getBean("demoServiceConsumer"); // 获取远程服务代理
        String hello = demoService.sayHello(key); // 执行远程方法
        Message message = new Message(key,Main.address,hello);
        return JSON.toJSONString(message);
    }

}
