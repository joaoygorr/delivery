package com.br.fiap.delivery.service.driver;

import java.util.List;

import com.br.fiap.delivery.module.Driver;

public interface DriverService {
    
    Driver save(Driver driver);
    List<Driver> findDriversByName(String driverName);

}
