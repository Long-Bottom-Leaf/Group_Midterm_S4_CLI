package com.example.airport_cli.service;

import com.example.airport_cli.client.ApiClient;
import com.example.airport_cli.model.Airport;
import com.example.airport_cli.model.City;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    @Mock
    private ApiClient apiClient;

    @InjectMocks
    private CityService cityService;

    @Test
    void testAllCities() throws Exception {
        City city = new City(2L, "St. John's", "Newfoundland", 110000);

        when(apiClient.getAllCities()).thenReturn(List.of(city));

        List<City> result = cityService.getAllCities();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Toronto", result.getFirst().getName());
        assertEquals(110000, result.getFirst().getPopulation());

        verify(apiClient).getAllCities();
    }

    @Test
    void testGetAirportsByCity() throws Exception {

        Airport airport = new Airport();

    }
}
