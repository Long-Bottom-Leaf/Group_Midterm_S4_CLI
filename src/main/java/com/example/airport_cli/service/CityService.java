package com.example.airport_cli.service;

import com.example.airport_cli.client.ApiClient;
import com.example.airport_cli.model.Airport;
import com.example.airport_cli.model.City;

import java.io.IOException;
import java.util.List;

public class CityService {

    private final ApiClient apiClient;

    public CityService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<City> getAllCities() {
        try {
            return apiClient.getAllCities();

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving cities.");

            return null;
        }
    }

    public List<Airport> getAirportsByCity(Long cityId) {
        try {
            return apiClient.getAirportsByCity(cityId);

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving airports.");

            return null;
        }
    }
}
