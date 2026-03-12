package com.example.airport_cli.cli;

import com.example.airport_cli.model.*;
import com.example.airport_cli.client.*;
import com.example.airport_cli.service.AircraftService;
import com.example.airport_cli.service.CityService;
import com.example.airport_cli.service.PassengerService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private AircraftService aircraftService;
    private CityService cityService;
    private PassengerService passengerService;

    public void menu() {
        scanner = new Scanner(System.in);

        aircraftService = new AircraftService();
        cityService = new CityService();
        passengerService = new PassengerService();
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();

            int choice = scanner.nextInt();
        }
    }

    private void printMenu() {

        System.out.println("======= Airport CLI =======");
        System.out.println("1. List Cities");
        System.out.println("2. Airports by City");
        System.out.println("3. Aircraft by Passenger");
        System.out.println("4. Airports by Passenger");
        System.out.println("5. Airports by Aircraft");
        System.out.println("6. Exit");

        System.out.print("Select option: ");
    }

    private void listCities() {
        List<City> cities = cityService.getAllCities();

        if (cities != null) {
            for (City city : cities) {
                System.out.println(city);
            }

        } else {
            System.out.println("No cities were found.");
        }
    }

    private void airportsByCity() {
        System.out.println("Enter city ID: ");
        Long cityId = scanner.nextLong();

        List<Airport> airports = cityService.getAirportsByCity(cityId);

        if (airports != null) {
            System.out.println(airports);

        } else {
            System.out.println("No airports were found.");
        }
    }
}
