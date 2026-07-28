package org.learnspringframework.springsecurity.csrf;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Keertan" , 91),
            new Student(2, "Chander", 89)
    ));


    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }


    @GetMapping("/csrf-token")
    public CsrfToken getCsrfTocken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/students")
    private Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
