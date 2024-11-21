package com.br.fiap.delivery.service.tracking;

import com.br.fiap.delivery.module.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackingService {
    Location updateLocation(Long deliveryId, double latitude, double longitude);

    List<Location> getDeliveryLocations(Long deliveryId);
}
