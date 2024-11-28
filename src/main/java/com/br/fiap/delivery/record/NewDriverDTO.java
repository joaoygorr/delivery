package com.br.fiap.delivery.record;

import com.br.fiap.delivery.module.Driver;

public record NewDriverDTO(
    String name,
        String vehicle,
        String phoneNumber) {

    public static Driver toEntity(NewDriverDTO dto) {
        final var entity = new Driver();
        entity.setName(dto.name());
        entity.setVehicle(dto.vehicle());
        entity.setPhoneNumber(dto.phoneNumber());
        entity.setAvailable(true);
        return entity;
    }
}
