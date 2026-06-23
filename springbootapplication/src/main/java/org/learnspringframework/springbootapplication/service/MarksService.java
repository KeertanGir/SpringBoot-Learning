package org.learnspringframework.springbootapplication.service;

import org.learnspringframework.springbootapplication.Data.MarksData;
import org.springframework.stereotype.Service;

@Service
public class MarksService {

//    Dependency Injection
    private final MarksData marksData;

    public MarksService(MarksData marksData){
       this.marksData = marksData;
    }

    public Integer getTotalMarks(){
        return marksData.getmarksData()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
    }



}
