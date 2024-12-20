package com.br.fiap.delivery.record;

import com.br.fiap.delivery.module.Delivery;

import java.time.LocalDateTime;

public record DeliveryDTO(Long id,
                          DriverDTO driver,
                          String status,
                          LocalDateTime estimatedDeliveryTime,
                          String destinationAddress) {

    public static DeliveryDTO toDto(Delivery delivery) {
        return new DeliveryDTO(
                delivery.getId(),
                DriverDTO.toDto(delivery.getDriver()),
                delivery.getStatus(),
                delivery.getEstimatedDeliveryTime(),
                delivery.getDestinationAddress()
        );
    }
}
