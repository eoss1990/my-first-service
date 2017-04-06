package my.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by yangyu on 16/11/14.
 */
@Path("myrest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyRest {

    @GET
    @Path("people/{key}")
    public People getPeople(@PathParam("key") String key){
        People people = new People(key,"nan");
        return people;
    }

    /**
     * 这个例子告诉我们使用jersey moxy处理json时返回对象不能是内部类，否则处理不了
     * @param key
     * @return
     */
    @GET
    @Path("person/{key}")
    public Person getPerson(@PathParam("key") String key){
        Person person = new Person(key,"nv");
        return person;
    }

    public class Person{

        private String name;
        private String sex;

        public Person(){}

        public Person(String name,String sex){
            this.name=name;
            this.sex=sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
