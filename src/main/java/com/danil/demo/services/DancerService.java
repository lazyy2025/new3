package com.danil.demo.services;

import com.danil.demo.models.Dancer;
import org.springframework.stereotype.Service;

@Service
public class DancerService {


    public Dancer jumper(String status){
        Dancer dancer1 = new Dancer();
        dancer1.name = "vova";

        if (status == "failed"){
            System.out.println(dancer1.name+" upal");
        }
        if (status == "ok"){
            System.out.println(dancer1.name+" ok");
        }
//        System.out.println(dancer1.name+"serviceworking");
        return dancer1;
    }


}
