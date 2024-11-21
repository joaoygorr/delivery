package com.br.fiap.delivery.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @Column(name = "id_driver")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String vehicle;

    private String phoneNumber;

    private Boolean available;
}
