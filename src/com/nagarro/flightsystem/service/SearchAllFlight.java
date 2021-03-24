/*
* Class name: SearchAllFlight
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 24/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 24/Mar/2021
*
* Description: Used for search list of flights
*/
package com.nagarro.flightsystem.service;

import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;

public interface SearchAllFlight {
    public void getFlight() throws IOException, CsvValidationException, NumberFormatException;
}
