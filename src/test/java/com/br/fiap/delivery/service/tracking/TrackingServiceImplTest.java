package com.br.fiap.delivery.service.tracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.br.fiap.delivery.exceptions.Exception404;
import com.br.fiap.delivery.mock.DeliveryMock;
import com.br.fiap.delivery.mock.LocationMock;
import com.br.fiap.delivery.module.Location;
import com.br.fiap.delivery.repository.DeliveryRepository;
import com.br.fiap.delivery.repository.LocationRepository;
import com.br.fiap.delivery.service.delivery.UpdateOrderService;

class TrackingServiceImplTest {

    @InjectMocks
    private TrackingServiceImpl trackingServiceImpl;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private UpdateOrderService updateOrderService;
    

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        trackingServiceImpl = new TrackingServiceImpl(locationRepository, deliveryRepository, updateOrderService);
    }

    @Test
    void testGetDeliveryLocations() {
        when(this.locationRepository.findByDeliveryId(anyLong())).thenReturn(List.of(LocationMock.build()));

        final var response = this.trackingServiceImpl.getDeliveryLocations(1L);

        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @Test
    void testUpdateLocation() {
        when(this.deliveryRepository.findById(anyLong())).thenReturn(Optional.of(DeliveryMock.build()));
        when(this.locationRepository.save(any(Location.class))).thenReturn(LocationMock.build());

        final var response = this.trackingServiceImpl.updateLocation(1L, 0, 0, false);

        assertNotNull(response);
    }

    @Test
    void testUpdateLocationNotFoundDriver() {
        when(this.deliveryRepository.findById(anyLong())).thenReturn(Optional.empty());

        final var response = assertThrows(Exception404.class,
                () -> this.trackingServiceImpl.updateLocation(1L, 0, 0, true));

        assertNotNull(response);
        assertEquals("Entrega não encontrada", response.getMessage());
    }
}
