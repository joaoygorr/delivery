package com.br.fiap.delivery.record;

import com.br.fiap.delivery.module.Location;

import java.time.LocalDateTime;

public record LocationDTO(Long id,
                          DeliveryDTO delivery,
                          double latitude,
                          double longitude,
                          LocalDateTime timestamp) {

    public static LocationDTO toDto(Location location) {
        return new LocationDTO(
                location.getId(),
                DeliveryDTO.toDto(location.getDelivery()),
                location.getLatitude(),
                location.getLongitude(),
                location.getTimestamp()
        );
    }
}
