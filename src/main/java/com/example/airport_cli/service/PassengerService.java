package com.example.airport_cli.service;

import com.example.airport_cli.client.ApiClient;
import com.example.airport_cli.model.Aircraft;
import com.example.airport_cli.model.Airport;
import com.example.airport_cli.model.Passenger;

import java.io.IOException;
import java.util.List;

public class PassengerService {

    private ApiClient apiClient;

    public PassengerService() {
        this.apiClient = new ApiClient();
    }

    public List<Passenger> getAllPassengers() {
        try {
            return apiClient.getAllPassengers();

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving passengers.");
            return null;
        }
    }

    public List<Aircraft> getAircraftByPassenger(Long passengerId) {
        try {
            return apiClient.getAircraftByPassenger(passengerId);

        } catch (IOException | InterruptedException error) {
            System.out.println("Error retrieving aircraft.");
            return null;
        }
    }

    public List<Airport> getAirportsByPassenger(Long passengerId) {
        try {
            return apiClient.getAirportsByPassenger(passengerId);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error retrieving airports.");
            return null;
        }
    }
}