package com.br.fiap.delivery.repository;

import com.br.fiap.delivery.module.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByAvailableTrue();
 
    List<Driver> findDriversByName(String name);
}
