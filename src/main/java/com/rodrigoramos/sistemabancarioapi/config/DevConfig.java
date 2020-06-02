package com.rodrigoramos.sistemabancarioapi.config;

import com.rodrigoramos.sistemabancarioapi.service.impl.OverdraftDB;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@AllArgsConstructor
@Configuration
@Profile("dev")
public class DevConfig {

    private final OverdraftDB overdraftDB;

    @Bean
    public boolean instantiateOverdraft() {
        overdraftDB.instantiateOverdraft();
        return true;
    }

}
