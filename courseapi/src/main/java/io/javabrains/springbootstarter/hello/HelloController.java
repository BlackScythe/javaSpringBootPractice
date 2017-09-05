package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Describes class as controller
@RestController
public class HelloController {
    //Tells which method to run when URI is called
    @RequestMapping("/hello")
    public String sayHi() {
        return "hi!";
    }


}
