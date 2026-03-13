package com.example.airport_cli.service;

import com.example.airport_cli.client.ApiClient;
import com.example.airport_cli.model.Airport;

import java.io.IOException;
import java.util.List;

public class AircraftService {

    private final ApiClient apiClient;

    public AircraftService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Airport> getAirportsByAircraft(Long aircraftId) {
        try {
            return apiClient.getAirportsByAircraft(aircraftId);

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving airports.");
            return null;
        }
    }
}
