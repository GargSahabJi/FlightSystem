/*
* Class name: FindFlightList
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 23/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 24/Mar/2021
*
* Description: Used for the print list of flights
*/
package com.nagarro.flightsystem.filecheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.nagarro.flightsystem.model.FlightInformation;
import com.nagarro.flightsystem.service.impl.FindFlightList;
import com.nagarro.flightsystem.sorting.FareSort;
import com.nagarro.flightsystem.sorting.FlightDurationSort;
import com.opencsv.exceptions.CsvValidationException;

public class FlightTracker implements Runnable {
    private static final String C_USERS_ARPITGARG02_ECLIPSE_WORKSPACE_AIR_FLIGHT_SYSTEM_BIN_RESOURCES = "C:/Users/arpitgarg02/eclipse-workspace/AirFlightSystem/bin/resources/";
    private static final String NO_RECORD_FOUND = "No Record Found";
    private static FlightInformation flight = new FlightInformation();
    private ArrayList<String> filesName = new ArrayList<>();
    private String departureLocation;
    private String arrivalLocation;
    private String flightDate;
    private String flightClass;
    private int sortingChoice;

    /**
     * @param filesName
     * @param departureLocation
     * @param arrivalLocation
     * @param flightDate
     * @param flightClass
     * @param sortingChoice
     */
    public FlightTracker(ArrayList<String> filesName, String departureLocation, String arrivalLocation,
            String flightDate, String flightClass, int sortingChoice) {
        this.filesName = filesName;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.flightDate = flightDate;
        this.flightClass = flightClass;
        this.sortingChoice = sortingChoice;
    }

    /**
     * Find the flights
     */
    private void getFlightData() {
        for (int i = 0; i < filesName.size(); i++) {
            FindFlightList searchFlight = new FindFlightList(
                    C_USERS_ARPITGARG02_ECLIPSE_WORKSPACE_AIR_FLIGHT_SYSTEM_BIN_RESOURCES + filesName.get(i),
                    departureLocation, arrivalLocation, flightDate, flightClass);
            try {
                searchFlight.findFlight();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CsvValidationException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        choiceForSorting(sortingChoice);
        showFlightList();
    }

    /**
     * select the choice option
     * 
     * @param choice
     */
    private static void choiceForSorting(int choice) {
        switch (choice) {
        case 1:
            Collections.sort(flight.getFlightList(), new FareSort());
            break;

        case 2:
            Collections.sort(flight.getFlightList(), new FlightDurationSort());
            break;

        default:
            break;
        }
    }

    /**
     * print the list of flights
     */
    private static void showFlightList() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %12s %10s %10s %10s %10s %10s", "Flight No.", "Departure", "Arrival",
                "Valid Till", "Time", "Duration", "fare", "Seat", "Class");
        System.out.println();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        if (flight.getFlightList().isEmpty()) {
            System.out.printf("%50s", NO_RECORD_FOUND);
            System.out.println();
        } else {
            flight.getFlightList().forEach(flightData -> printFlightData(flightData));
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }

    public static void printFlightData(FlightInformation flightData) {
        System.out.printf("%8s %8s %10s %15s %10s %8s %15s %7s %8s", flightData.getFlightNumber(),
                flightData.getDepartureLoaction(), flightData.getArrivalLocation(), flightData.getValidTill(),
                flightData.getFlightTime(), flightData.getFlightDuration(), flightData.getFare(),
                flightData.getSeatAvailability(), flightData.getFlightClass());
        System.out.println();
    }

    @Override
    public void run() {
        getFlightData();
    }
}
