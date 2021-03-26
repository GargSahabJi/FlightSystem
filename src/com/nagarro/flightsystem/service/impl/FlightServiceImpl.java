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
* Description: Find the all flights
*/
package com.nagarro.flightsystem.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.flightsystem.model.FlightData;
import com.nagarro.flightsystem.service.FlightService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class FlightServiceImpl implements FlightService {
    private static final String C_USERS_ARPITGARG02_ECLIPSE_WORKSPACE_AIR_FLIGHT_SYSTEM_BIN_RESOURCES = "C:/Users/arpitgarg02/eclipse-workspace/AirFlightSystem/bin/resources/";
    private static final String B = "B";
    static ArrayList<String> flightData;
    private String fileName;
    private String departureLocation;
    private String arrivalLocaton;
    private String flightDate;
    private String flightClass;

    /**
     * Find all the flights
     * 
     * @throws IOException
     * @throws CsvValidationException
     * @throws NumberFormatException
     */
    public void getFlight(FlightData flightForSearch)
            throws IOException, CsvValidationException, NumberFormatException {
        this.fileName = C_USERS_ARPITGARG02_ECLIPSE_WORKSPACE_AIR_FLIGHT_SYSTEM_BIN_RESOURCES
                + flightForSearch.getFlieForRead();
        this.departureLocation = flightForSearch.getDepartureLoaction();
        this.arrivalLocaton = flightForSearch.getArrivalLocation();
        this.flightDate = flightForSearch.getValidTill();
        this.flightClass = flightForSearch.getFlightClass();
        ArrayList<FlightData> flightDataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] lineInCSV = reader.readNext();
            while ((lineInCSV = reader.readNext()) != null) {
                String[] flight = lineInCSV[0].split("\\|");
                FlightData flightInformation = new FlightData();
                flightInformation.setFlightNumber(flight[0]);
                flightInformation.setDepartureLocation(flight[1]);
                flightInformation.setArrivalLocation(flight[2]);
                flightInformation.setValidTill(flight[3]);
                flightInformation.setFlightTime(flight[4]);
                flightInformation.setFlightDuration(Float.parseFloat(flight[5]));
                if (flightClass.equals(B)) {
                    flightInformation.setFare(new Double(Float.parseFloat(flight[6]) * 1.4).floatValue());
                } else {
                    flightInformation.setFare(Float.parseFloat(flight[6]));
                }
                flightInformation.setSeatAvailability(flight[7]);
                flightInformation.setFlightClass(flight[8]);
                flightDataList.add(flightInformation);
            }
            List<FlightData> flightsForUser = flightDataList.stream()
                    .filter(flightInformation -> flightInformation.getDepartureLoaction().equals(departureLocation)
                            && flightInformation.getArrivalLocation().equals(arrivalLocaton)
                            && flightInformation.getValidTill().equals(flightDate)
                            && (flightInformation.getFlightClass().equals(flightClass)
                                    || flightInformation.getFlightClass().contains(flightClass)))
                    .collect(Collectors.toList());
            new FlightData().addFlight(flightsForUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}