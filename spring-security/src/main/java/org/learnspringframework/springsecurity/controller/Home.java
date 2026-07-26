package org.learnspringframework.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Home {

    @GetMapping("/")
    public String homePage(HttpServletRequest request){

//        every thing behind the Every Application Here Are Servlets that performs the Every Action,
//        Even Every controller are the servlets
//        request.getSession().getId()  -->   this will get the Session id of the login

        return "Spring Security Home Page : " + request.getSession().getId();
    }

}
