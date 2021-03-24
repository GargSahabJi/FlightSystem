/*
* Class name: FlightDurationSort
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
* Description: Sort the list of flights according to duration of flight
*/
package com.nagarro.flightsystem.sorting;

import java.util.Comparator;

import com.nagarro.flightsystem.model.FlightInformation;

public class FlightDurationSort implements Comparator<FlightInformation> {

    @Override
    public int compare(FlightInformation flight1, FlightInformation flight2) {
        if (flight1.getFlightDuration() > flight2.getFlightDuration())
            return 1;
        else if (flight1.getFlightDuration() < flight2.getFlightDuration())
            return -1;
        else
            return 0;
    }

}
