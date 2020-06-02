package com.rodrigoramos.sistemabancarioapi.service.impl;

import com.rodrigoramos.sistemabancarioapi.model.LimitConfiguration;
import com.rodrigoramos.sistemabancarioapi.repository.LimitConfigurationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class OverdraftDB {

    private final LimitConfigurationRepository limitConfigurationRepository;

    @Value("${value.limite.range1}")
    double limitRange1;
    @Value("${value.limite.range2}")
    double limitRange2;
    @Value("${value.limite.range3}")
    double limitRange3;
    @Value("${value.limite.range4}")
    double limitRange4;

    public OverdraftDB(LimitConfigurationRepository limitConfigurationRepository) {
        this.limitConfigurationRepository = limitConfigurationRepository;
    }

    public void instantiateOverdraft() {

        LimitConfiguration o1 = new LimitConfiguration(0, 1, limitRange1);
        LimitConfiguration o2 = new LimitConfiguration(2, 5, limitRange2);
        LimitConfiguration o3 = new LimitConfiguration(6, 8, limitRange3);
        LimitConfiguration o4 = new LimitConfiguration(0, 9, limitRange4);


        limitConfigurationRepository.saveAll(Arrays.asList(o1, o2, o3, o4));


    }
}
