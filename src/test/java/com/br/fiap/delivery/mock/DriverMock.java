package com.br.fiap.delivery.mock;

import com.br.fiap.delivery.module.Driver;

public class DriverMock {

    public static Driver build() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setName("name");
        driver.setPhoneNumber("000000000");
        driver.setVehicle("vehicle");
        driver.setAvailable(true);
        return driver;
    }

}
