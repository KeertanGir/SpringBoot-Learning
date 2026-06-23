package org.learnspringframework.springbootapplication.Data;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Component
public class MarksData {

    public List<Integer> getmarksData(){
        return Arrays.asList(12,23,12,31,91,98,21);
    }

}
