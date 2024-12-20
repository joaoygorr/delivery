package com.br.fiap.delivery.service.tracking;

import com.br.fiap.delivery.exceptions.Exception404;
import com.br.fiap.delivery.module.Delivery;
import com.br.fiap.delivery.module.Location;
import com.br.fiap.delivery.repository.DeliveryRepository;
import com.br.fiap.delivery.repository.LocationRepository;
import com.br.fiap.delivery.service.delivery.UpdateOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrackingServiceImpl implements TrackingService {

    private final LocationRepository locationRepository;
    private final DeliveryRepository deliveryRepository;
    private final UpdateOrderService updateOrderService;

    @Autowired
    public TrackingServiceImpl(LocationRepository locationRepository, DeliveryRepository deliveryRepository, UpdateOrderService updateOrderService) {
        this.locationRepository = locationRepository;
        this.deliveryRepository = deliveryRepository;
        this.updateOrderService = updateOrderService;
    }

    @Override
    public Location updateLocation(Long deliveryId, double latitude, double longitude, boolean isDelivered) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new Exception404("Entrega não encontrada"));
        delivery.setDelivered(isDelivered);
        if(isDelivered){try{
            this.updateOrderService.updateOrderStatus(delivery.getPedidoId(), "DELIVERED");
        } catch (Exception e){
            throw new Exception404("Id do pedido inválido.");
        }}

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
