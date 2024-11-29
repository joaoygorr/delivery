package com.br.fiap.delivery.service.tracking;

import com.br.fiap.delivery.module.Location;

import java.util.List;

public interface TrackingService {
    Location updateLocation(Long deliveryId, double latitude, double longitude, boolean isDelivered);

    List<Location> getDeliveryLocations(Long deliveryId);
}
