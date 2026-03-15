package com.example.airport_cli.service;

import com.example.airport_cli.client.ApiClient;
import com.example.airport_cli.model.Airport;
import com.example.airport_cli.model.Passenger;
import com.example.airport_cli.model.Aircraft;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PassengerServiceTest {

    @Mock
    private ApiClient apiClient;

    @InjectMocks
    private PassengerService passengerService;

    @Test
    void testGetAirportsByPassenger() throws Exception {

        Airport airport = new Airport();
        airport.setName("Super Cool Airport");

        when(apiClient.getAirportsByPassenger(1L)).thenReturn(List.of(airport));

        List<Airport> result = passengerService.getAirportsByPassenger(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Super Cool Airport", result.get(0).getName());

        verify(apiClient).getAirportsByPassenger(1L);
    }

    @Test
    void testGetAircraftByPassenger() throws Exception {

        Aircraft aircraft = new Aircraft();
        aircraft.setType("Boeing 737");

        when(apiClient.getAircraftByPassenger(1L)).thenReturn(List.of(aircraft));

        List<Aircraft> result = passengerService.getAircraftByPassenger(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Boeing 737", result.get(0).getType());

        verify(apiClient).getAircraftByPassenger(1L);
    }
}