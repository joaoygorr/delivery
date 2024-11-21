package com.br.fiap.delivery.repository;

import com.br.fiap.delivery.module.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
