package ru.x.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.x.core.models.Dancer;

@Service
public class DancerService {
    public Dancer dancer(){
        Dancer dance = new Dancer();
        dance.name = "asdf";
        dance.age = "345";

        return dance;
    }


}
