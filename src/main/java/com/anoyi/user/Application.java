package com.anoyi.user;

import com.anoyi.BootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
