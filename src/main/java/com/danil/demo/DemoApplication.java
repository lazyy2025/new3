package com.danil.demo;

import com.danil.demo.models.Dancer;
import com.danil.demo.services.DancerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static DancerService dancerService;

    public DemoApplication(DancerService dancerService) {
        this.dancerService = dancerService;
    }

    public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		System.out.println("hello world");
		System.out.println("hello worldw2");
		;
		System.out.println(dancerService.jumper("ok"));
	}

}
