package com.anoyi.user;

import com.anoyi.BootApplication;
import com.anoyi.grpc.annotation.GrpcServiceScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@GrpcServiceScan(packages = "com.anoyi.server.rpc.user")
public class Application extends BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
