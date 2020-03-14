package com.lembreteappspring.lembreteappspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class LembreteappspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LembreteappspringApplication.class, args);
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        return "index";
    }

}
