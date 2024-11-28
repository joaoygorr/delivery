package com.br.fiap.delivery.service.driver;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.fiap.delivery.module.Driver;
import com.br.fiap.delivery.repository.DriverRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public Driver save(Driver driver) {
        return this.driverRepository.save(driver);
    }

    @Override
    public List<Driver> findDriversByName(String driverName) {
        return this.driverRepository.findDriversByName(driverName);
    }

}
