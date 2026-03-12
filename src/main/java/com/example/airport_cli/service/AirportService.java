package com.example.airport_cli.service;

import com.example.airport_cli.client.ApiClient;
import com.example.airport_cli.model.Airport;

import java.io.IOException;
import java.util.List;

public class AirportService {

    private final ApiClient apiClient;

    public AirportService() {
        this.apiClient = new ApiClient();
    }

    public List<Airport> getAirportsByCity(Long cityId) {
        try {
            return apiClient.getAirportsByCity(cityId);

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving airports.");
            return null;
        }
    }

    public List<Airport> getAirportsByPassenger(Long passengerId) {
        try {
            return apiClient.getAirportsByPassenger(passengerId);

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving airports.");
            return null;
        }
    }

    public List<Airport> getAirportsByAircraft(Long aircraftId) {
        try {
            return apiClient.getAirportsByAircraft(aircraftId);

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving aircraft.");
            return null;
        }
    }
}
