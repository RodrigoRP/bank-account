package com.rodrigoramos.sistemabancarioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
public class SistemaBancarioApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaBancarioApiApplication.class, args);
    }

}
