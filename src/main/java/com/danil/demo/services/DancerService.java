package com.danil.demo.services;

import com.danil.demo.models.Dancer;
import com.danil.generated.swagger.model.v1.EtcdModel;
import org.jooq.meta.derby.sys.Sys;
import org.springframework.stereotype.Service;

@Service
public class DancerService {


    public Dancer jumper(String status){

        EtcdModel etcdModel = new EtcdModel();
        etcdModel.count("10ehgg");
        System.out.println(etcdModel.getCount());
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

    public Dancer looper(String status){

        EtcdModel etcdModel = new EtcdModel();
        etcdModel.count("10ehgg");
        System.out.println(etcdModel.getCount());
        Dancer dancer1 = new Dancer();
        dancer1.name = "kolya";

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
