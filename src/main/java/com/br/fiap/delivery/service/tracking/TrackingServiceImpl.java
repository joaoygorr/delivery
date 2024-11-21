package com.br.fiap.delivery.service.tracking;

import com.br.fiap.delivery.module.Delivery;
import com.br.fiap.delivery.module.Location;
import com.br.fiap.delivery.repository.DeliveryRepository;
import com.br.fiap.delivery.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrackingServiceImpl implements TrackingService {

    private final LocationRepository locationRepository;
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public TrackingServiceImpl(LocationRepository locationRepository, DeliveryRepository deliveryRepository) {
        this.locationRepository = locationRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Location updateLocation(Long deliveryId, double latitude, double longitude) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

        Location location = new Location();
        location.setDelivery(delivery);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setTimestamp(LocalDateTime.now());

        return locationRepository.save(location);
    }

    @Override
    public List<Location> getDeliveryLocations(Long deliveryId) {
        return locationRepository.findByDeliveryId(deliveryId);
    }
}
