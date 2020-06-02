package com.rodrigoramos.sistemabancarioapi.repository;

import com.rodrigoramos.sistemabancarioapi.model.LimitConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LimitConfigurationRepository extends JpaRepository<LimitConfiguration, Long> {

    @Query(value = "SELECT * FROM lIMIT_CONFIGURATION WHERE ?1 BETWEEN MIN  AND MAX limit 1", nativeQuery = true)
    LimitConfiguration findLimit(Integer value);

}
