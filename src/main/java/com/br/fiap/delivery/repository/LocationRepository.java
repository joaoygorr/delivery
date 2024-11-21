package com.br.fiap.delivery.repository;

import com.br.fiap.delivery.module.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByDeliveryId(Long deliveryId);

}
