package com.br.fiap.delivery.repository;

import com.br.fiap.delivery.module.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByAvailableTrue();
 
    List<Driver> findDriversByName(String name);
}
