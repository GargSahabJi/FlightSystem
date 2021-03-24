/*
* Class name: InvalidStateException
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
* Last updated Date: 23/Mar/2021
*
* Description: give description of the Exceptions
*/
package com.nagarro.flightsystem.exception;

public class InvalidStateException extends RuntimeException {

    /**
     * Give Exception message
     * 
     * @param exceptionMessage
     */
    public InvalidStateException(String exceptionMessage) {
        System.out.println("Exception: " + exceptionMessage);
    }

    public InvalidStateException() {

    }

}
