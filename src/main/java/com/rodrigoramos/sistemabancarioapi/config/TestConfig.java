package com.rodrigoramos.sistemabancarioapi.config;

import com.rodrigoramos.sistemabancarioapi.service.impl.DatabaseService;
import com.rodrigoramos.sistemabancarioapi.service.impl.OverdraftDB;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@AllArgsConstructor
@Configuration
@Profile("test")
public class TestConfig {

    private final OverdraftDB overdraftDB;
    private final DatabaseService dbService;

    @Bean
    public boolean instantiateOverdraft() {
        overdraftDB.instantiateOverdraft();
        return true;
    }


    @Bean
    public boolean instantiateDatabase() {
        dbService.instantiateDatabase();
        return true;
    }


}
