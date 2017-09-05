package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {
    public static void main (String[] args){
        //Calling a static method, passing the main class and run arguments. This method
        //instantiates a servlet container that allows our app to run in standalone.

        SpringApplication.run(CourseApiApp.class, args);
    }
}
