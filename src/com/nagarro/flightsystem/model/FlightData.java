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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class FlightData {
    @Id
    @Column(name = "Flight_Number")
    private String flightNumber;
    @Column(name = "Departure_Loc")
    private String departureLocation;
    @Column(name = "Arrival_Loc")
    private String arrivalLocation;
    @Column(name = "Valid_Till")
    private String validTill;
    @Column(name = "Flight_Time")
    private String flightTime;
    @Column(name = "Flight_Duration", length = 10, precision = 4)
    private float flightDuration;
    @Column(name = "Fare", length = 10, precision = 4)
    private float fare;
    @Column(name = "Seat_Availability")
    private String seatAvailability;
    @Column(name = "Flight_Class")
    private String flightClass;
    @Transient
    private String flieForRead;

    public String getFlieForRead() {
        return flieForRead;
    }

    public void setFlieForRead(String flieForRead) {
        this.flieForRead = flieForRead;
    }

    private static ArrayList<FlightData> flightList = new ArrayList<>();

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
    public void setFare(float fare) {
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
    public void addFlight(List<FlightData> flightToAdd) {
        flightList.addAll(flightToAdd);
    }

    /**
     * @return flight list
     */
    public ArrayList<FlightData> getFlightList() {
        return flightList;
    }
}
