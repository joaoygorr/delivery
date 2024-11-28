package com.br.fiap.delivery.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @Column(name = "id_delivery")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_driver")
    private Driver driver;

    private String status;

    private LocalDateTime estimatedDeliveryTime;

    private String destinationAddress;

}
