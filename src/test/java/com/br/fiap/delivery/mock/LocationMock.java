package com.br.fiap.delivery.mock;

import java.time.LocalDateTime;

import com.br.fiap.delivery.module.Location;

public class LocationMock {

    public static Location build() {
        Location location = new Location();
        location.setId(1L);
        location.setDelivery(DeliveryMock.build());
        location.setLatitude(0);
        location.setLongitude(0);
        location.setTimestamp(LocalDateTime.now());
        return location;
    }

}
