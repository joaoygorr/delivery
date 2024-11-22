package com.br.fiap.delivery.repository;

import com.br.fiap.delivery.module.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByDeliveryId(Long deliveryId);

}
