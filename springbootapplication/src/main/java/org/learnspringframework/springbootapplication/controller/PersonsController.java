package org.learnspringframework.springbootapplication.controller;

import org.learnspringframework.springbootapplication.Data.Persons;
import org.learnspringframework.springbootapplication.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {

    private final PersonService personService;

    public PersonsController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/users")
    public List<Persons> getUsers(){
        return personService.getAllUsers();
    }



}
