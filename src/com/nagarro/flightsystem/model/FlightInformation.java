/*
* Class name: FlightInformation
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
* Description: Save Flight data in the form of nodes
*/
package com.nagarro.flightsystem.model;

import java.util.ArrayList;

public class FlightInformation {
    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private String validTill;
    private String flightTime;
    private float flightDuration;
    private double fare;
    private String seatAvailability;
    private String flightClass;
    private static ArrayList<FlightInformation> flightList = new ArrayList<>();

    /**
     * @param flightNumber
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * @return flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * @return flight time
     */
    public String getFlightTime() {
        return flightTime;
    }

    /**
     * @param flightTime
     */
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    /**
     * @return flight duration
     */
    public float getFlightDuration() {
        return flightDuration;
    }

    /**
     * @param flightDuration
     */
    public void setFlightDuration(float flightDuration) {
        this.flightDuration = flightDuration;
    }

    /**
     * @return fare
     */
    public double getFare() {
        return fare;
    }

    /**
     * @param fare
     */
    public void setFare(double fare) {
        this.fare = fare;
    }

    /**
     * @return seat Availability
     */
    public String getSeatAvailability() {
        return seatAvailability;
    }

    /**
     * @param seatAvailability
     */
    public void setSeatAvailability(String seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    /**
     * @return flight class
     */
    public String getFlightClass() {
        return flightClass;
    }

    /**
     * @param flightClass
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    /**
     * @param departureLocation
     */
    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    /**
     * @return departure location
     */
    public String getDepartureLoaction() {
        return departureLocation;
    }

    /**
     * @param arrivalLocation
     */
    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    /**
     * @return arrival location
     */
    public String getArrivalLocation() {
        return arrivalLocation;
    }

    /**
     * @param validTill
     */
    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    /**
     * @return valid till
     */
    public String getValidTill() {
        return validTill;
    }

    /**
     * @param flightToAdd
     */
    public void addFlight(FlightInformation flightToAdd) {
        flightList.add(flightToAdd);
    }

    /**
     * @return flight list
     */
    public ArrayList<FlightInformation> getFlightList() {
        return flightList;
    }
}
