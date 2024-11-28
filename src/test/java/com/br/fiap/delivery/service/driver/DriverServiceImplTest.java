package com.br.fiap.delivery.service.driver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.br.fiap.delivery.mock.DriverMock;
import com.br.fiap.delivery.module.Driver;
import com.br.fiap.delivery.repository.DriverRepository;

class DriverServiceImplTest {

    @InjectMocks
    private DriverServiceImpl driverService;

    @Mock
    private DriverRepository driverRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.driverService = new DriverServiceImpl(driverRepository);
    }

    @Test
    void testFindDriversByName() {
        when(this.driverRepository.findDriversByName(anyString())).thenReturn(List.of(DriverMock.build()));

        final var response = this.driverService.findDriversByName("");

        assertNotNull(response);
        assertFalse(response.isEmpty());

    }

    @Test
    void testSave() {
        when(this.driverRepository.save(any(Driver.class))).thenReturn(DriverMock.build());

        final var response = this.driverRepository.save(new Driver());

        assertNotNull(response);
    }
}
