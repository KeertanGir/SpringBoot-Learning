package org.learnspringframework.restfullwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//REST API
@RestController
public class HelloWorldController {

//    /hello-world
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean( String.format("Hello World, %s", name) );
    }
}
