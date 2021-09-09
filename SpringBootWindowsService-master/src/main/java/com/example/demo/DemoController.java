package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

/**
 * A simple rest controller
 */
@RestController
public class DemoController {

    private final ApplicationContext ctx;

    @Autowired
    public DemoController(ApplicationContext ctx){
        this.ctx = ctx;
    }

    @PostMapping("/request")
    public void postController(
            @RequestBody String password) {

        //if (password.equals("")) {

        try {
            File myObj = new File("programFinished.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        SpringApplication.exit(ctx, () -> 0);

        //}
    }
}
