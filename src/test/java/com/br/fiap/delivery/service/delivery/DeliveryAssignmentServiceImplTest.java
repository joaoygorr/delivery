package com.br.fiap.delivery.service.delivery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.br.fiap.delivery.mock.DeliveryMock;
import com.br.fiap.delivery.mock.DriverMock;
import com.br.fiap.delivery.module.Delivery;
import com.br.fiap.delivery.repository.DeliveryRepository;
import com.br.fiap.delivery.repository.DriverRepository;

class DeliveryAssignmentServiceImplTest {

    @InjectMocks
    private DeliveryAssignmentServiceImpl deliveryAssignmentServiceImpl;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private DeliveryRepository deliveryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deliveryAssignmentServiceImpl = new DeliveryAssignmentServiceImpl(driverRepository, deliveryRepository);
    }

    @Test
    void testAssignDelivery() {

        when(driverRepository.findByAvailableTrue()).thenReturn(List.of(DriverMock.build()));
        when(deliveryRepository.save(any(Delivery.class))).thenReturn(DeliveryMock.build());

        final var response = this.deliveryAssignmentServiceImpl.assignDelivery("", "");

        assertNotNull(response);
    }

    @Test
    void testAssignDeliveryWithoutDriver() {

        when(driverRepository.findByAvailableTrue()).thenReturn(List.of());

        final var response = assertThrows(RuntimeException.class,
                () -> this.deliveryAssignmentServiceImpl.assignDelivery("", ""));

        assertNotNull(response);
        assertEquals("Nenhum entregador disponível.", response.getMessage());
    }
}
