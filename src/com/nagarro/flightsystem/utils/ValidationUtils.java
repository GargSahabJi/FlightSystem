/*
* Class name: ValidationUtils
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
* Description: Validate the inputs for flights information
*/
package com.nagarro.flightsystem.utils;

import com.nagarro.flightsystem.exception.InvalidStateException;

public class ValidationUtils {

    private static final String INVALID_DATE = "Invalid date!";
    private static final String INVALID_INPUT_CHOICE_IS_INTEGER = "Invalid input ! choice is integer.";
    private static final String INVALID_FLIGHT_CLASS = "Invalid flight class!";
    private static final String INVALID_INPUT = "Invalid input!";

    /**
     * validate the flight name contains only alphabet and must be of 3 characters
     * 
     * @param name
     */
    public void nameValidation(String name) {
        if (ContainsOnlyAlphabet(name) || name.length() != 3) {
            throw new InvalidStateException(INVALID_INPUT);
        }
    }

    /**
     * validate the flight name contains only alphabet
     * 
     * @param itemName
     * @return
     */
    public boolean ContainsOnlyAlphabet(String itemName) {
        return ((itemName != null) && (itemName.matches("^[a-zA-Z]*$"))) ? false : true;
    }

    /**
     * Validate the flight class
     * 
     * @param flightClass
     */
    public void flightClassValidation(String flightClass) {
        if (flightClass.equals("E") || flightClass.equals("B") || flightClass.equals("EB")) {

        } else {
            throw new InvalidStateException(INVALID_FLIGHT_CLASS);
        }
    }

    /**
     * Validate the choice
     * 
     * @param sortingChoice
     */
    public void choiceValidation(String sortingChoice) {
        try {
            Integer.parseInt(sortingChoice);
        } catch (Exception e) {
            throw new InvalidStateException(INVALID_INPUT_CHOICE_IS_INTEGER);
        }
    }

    /**
     * Validate the flight date
     * 
     * @param flightDate
     */
    public void flightDateValidation(String flightDate) {
        if (flightDate.length() != 10) {
            throw new InvalidStateException(INVALID_DATE);
        } else if (flightDate.charAt(2) != '-' && flightDate.charAt(5) != '-') {
            throw new InvalidStateException(INVALID_DATE);
        }
        try {
            String flightDateCheck = flightDate.substring(0, 2) + flightDate.substring(3, 5) + flightDate.substring(6);
            Integer.parseInt(flightDateCheck);
        } catch (Exception e) {
            throw new InvalidStateException(INVALID_DATE);
        }
    }

    /**
     * Class Validation of the flight
     * 
     * @param flightClass
     */
    public void classValidation(String flightClass) {
        if (ContainsOnlyAlphabet(flightClass)) {
            throw new InvalidStateException(INVALID_INPUT);
        }
    }
}
