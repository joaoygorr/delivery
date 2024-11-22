package com.br.fiap.delivery.mock;

import java.time.LocalDateTime;

import com.br.fiap.delivery.module.Delivery;

public class DeliveryMock {

    public static Delivery build() {
        Delivery delivery = new Delivery();
        delivery.setDriver(DriverMock.build());
        delivery.setStatus("status");
        delivery.setEstimatedDeliveryTime(LocalDateTime.now());
        delivery.setDestinationAddress("destinationAddress");
        return delivery;
    }

}
