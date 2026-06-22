package org.learnspringframework.gamerunner.enterprice.data;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EnterpriseData {

    public List<Integer> getBusinessData(){
        return Arrays.asList(12,23,4,11,50);
    }
}
