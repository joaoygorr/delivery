package com.br.fiap.delivery.service.delivery;

import com.br.fiap.delivery.module.Delivery;
import com.br.fiap.delivery.module.Driver;
import com.br.fiap.delivery.repository.DeliveryRepository;
import com.br.fiap.delivery.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAssignmentServiceImpl implements DeliveryAssignmentService {

    private final DriverRepository driverRepository;
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryAssignmentServiceImpl(DriverRepository driverRepository, DeliveryRepository deliveryRepository) {
        this.driverRepository = driverRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery assignDelivery(String destinationAddress) {
        Driver availableDriver = driverRepository.findByAvailableTrue().stream().findFirst().orElseThrow(
                () -> new RuntimeException("Nenhum entregador disponível."));

        availableDriver.setAvailable(false);
        driverRepository.save(availableDriver);

        Delivery delivery = new Delivery();
        delivery.setDriver(availableDriver);
        delivery.setStatus("ATRIBUIDA");
        delivery.setDestinationAddress(destinationAddress);

        return deliveryRepository.save(delivery);
    }
}
