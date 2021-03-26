/*
* Class name: FareSort
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
* Description: Sort the list of flights according to fare 
*/
package com.nagarro.flightsystem.sorting;

import java.util.Comparator;

import com.nagarro.flightsystem.model.FlightData;

public class FareSort implements Comparator<FlightData> {

    @Override
    public int compare(FlightData flight1, FlightData flight2) {
        if (flight1.getFare() > flight2.getFare())
            return 1;
        else if (flight1.getFare() < flight2.getFare())
            return -1;
        else
            return 0;
    }
}
