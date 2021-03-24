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
import java.util.Arrays;

import com.nagarro.flightsystem.model.FlightInformation;
import com.nagarro.flightsystem.service.SearchAllFlight;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class FindFlightList implements SearchAllFlight{
    static ArrayList<String> flightData;
    private String fileName;
    private String departureLocation;
    private String arrivalLocaton;
    private String flightDate;
    private String flightClass;
    private static FlightInformation flightInfo;

    /**
     * @param fileName
     * @param departureLocation
     * @param arrivalLocaton
     * @param flightDate
     * @param flightClass
     */
    public FindFlightList(String fileName, String departureLocation, String arrivalLocaton, String flightDate,
            String flightClass) {
        this.fileName = fileName;
        this.departureLocation = departureLocation;
        this.arrivalLocaton = arrivalLocaton;
        this.flightDate = flightDate;
        this.flightClass = flightClass;
    }

    /**
     * Find all the flights
     * 
     * @throws IOException
     * @throws CsvValidationException
     * @throws NumberFormatException
     */
    public void findFlight() throws IOException, CsvValidationException, NumberFormatException {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                String[] flight = lineInArray[0].split("\\|");
                flightData = new ArrayList<String>(Arrays.asList(flight));
                if (flightData.get(1).equals(departureLocation) && flightData.get(2).equals(arrivalLocaton)
                        && flightData.get(3).equals(flightDate)
                        && (flightData.get(8).equals(flightClass) || flightData.get(8).contains(flightClass))) {
                    flightInfo = new FlightInformation();
                    flightInfo.setFlightNumber(flightData.get(0));
                    flightInfo.setDepartureLocation(flightData.get(1));
                    flightInfo.setArrivalLocation(flightData.get(2));
                    flightInfo.setValidTill(flightData.get(3));
                    flightInfo.setFlightTime(flightData.get(4));
                    flightInfo.setFlightDuration(Float.parseFloat(flightData.get(5)));
                    if (flightClass.equals("B")) {
                        flightInfo.setFare((Float.parseFloat(flightData.get(6))) * 1.4);
                    } else {
                        flightInfo.setFare(Float.parseFloat(flightData.get(6)));
                    }
                    flightInfo.setSeatAvailability(flightData.get(7));
                    flightInfo.setFlightClass(flightData.get(8));
                    flightInfo.addFlight(flightInfo);
                }
                flightData.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
