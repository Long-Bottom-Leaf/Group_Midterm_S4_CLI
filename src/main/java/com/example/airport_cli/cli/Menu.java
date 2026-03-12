package com.example.airport_cli.cli;

import com.example.airport_cli.model.*;
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

    public Menu() {
        scanner = new Scanner(System.in);
        aircraftService = new AircraftService();
        cityService = new CityService();
        passengerService = new PassengerService();
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();

            int choice;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {

                case 1:
                    listCities();
                    break;

                case 2:
                    airportsByCity();
                    break;

                case 3:
                    aircraftByPassenger();
                    break;

                case 4:
                    airportsByPassenger();
                    break;

                case 5:
                    airportsByAircraft();
                    break;

                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
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
        System.out.print("Enter city ID: ");
        Long cityId = scanner.nextLong();

        List<Airport> airports = cityService.getAirportsByCity(cityId);

        if (airports != null) {
            for (Airport airport : airports) {
                System.out.println(airport);
            }

        } else {
            System.out.println("No airports were found.");
        }
    }

    private void aircraftByPassenger() {
        System.out.print("Enter passenger ID: ");
        Long passengerId = scanner.nextLong();

        List<Aircraft> aircraft = passengerService.getAircraftByPassenger(passengerId);

        if (aircraft != null) {
            for (Aircraft aircraft1 : aircraft) {
                System.out.println(aircraft1);
            }

        } else {
            System.out.println("No aircraft found.");
        }
    }

    private void airportsByPassenger() {
        System.out.print("Enter passenger ID: ");
        Long passengerId = scanner.nextLong();

        List<Airport> airports = passengerService.getAirportsByPassenger(passengerId);

        if (airports != null) {
            for (Airport airport : airports) {
                System.out.println(airport);
            }

        } else {
            System.out.println("No airports found.");
        }
    }

    private void airportsByAircraft() {
        System.out.print("Enter aircraft ID: ");
        Long aircraftId = scanner.nextLong();

        List<Airport> airports = aircraftService.getAirportsByAircraft(aircraftId);

        if (airports != null) {
            for (Airport airport : airports) {
                System.out.println(airport);
            }

        } else {
            System.out.println("No airports found.");
        }
    }
}
