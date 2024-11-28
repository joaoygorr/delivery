package com.br.fiap.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.delivery.record.DriverDTO;
import com.br.fiap.delivery.record.NewDriverDTO;
import com.br.fiap.delivery.service.driver.DriverService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/driver")
@Tag(name = "Driver", description = "Driver related endpoint")
@AllArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    public ResponseEntity<Object> findDriverByName(@RequestParam(name = "driverName", defaultValue = "") String driverName) {
        final var response = this.driverService.findDriversByName(driverName);
        return ResponseEntity.ok(response.stream().map(DriverDTO::toDto).toList());
    }

    @PostMapping
    public ResponseEntity<Object> saveDriver(@RequestBody NewDriverDTO dto) {
        final var response =  this.driverService.save(NewDriverDTO.toEntity(dto));
        return ResponseEntity.ok(response);
    }

    
}
