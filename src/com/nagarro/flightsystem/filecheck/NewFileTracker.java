/*
* Class name: FolderTracker
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
* Description: Track the folder after 20 second for a new file
*/
package com.nagarro.flightsystem.filecheck;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.nagarro.flightsystem.service.impl.FindFlight;
import com.opencsv.exceptions.CsvValidationException;

public class NewFileTracker implements Runnable {
    private static boolean checkNewFiles = false;
    private static ArrayList<String> newFilesName = new ArrayList<>();
    private static ArrayList<String> oldFilesName = new ArrayList<>();
    private static String departureLocation;
    private static String arrivalLocation;
    private static String flightDate;
    private static String flightClass;

    /**
     * @param oldFilesName
     * @param departureLocation
     * @param arrivalLocation
     * @param flightDate
     * @param flightClass
     */
    public NewFileTracker(ArrayList<String> oldFilesName, String departureLocation, String arrivalLocation,
            String flightDate, String flightClass) {
        this.oldFilesName = oldFilesName;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.flightDate = flightDate;
        this.flightClass = flightClass;
    }

    /**
     * Get all files
     */
    private void getFiles() {
        try {
            File folder = new File("C:/Users/arpitgarg02/eclipse-workspace/AirFlightSystem/bin/Assignment Links/");
            for (File file : folder.listFiles()) {
                String name = file.getName();
                if (!newFilesName.contains(name)) {
                    newFilesName.add(name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * check for new files, if a new file come then process it
     * 
     * @throws CsvValidationException
     * @throws NumberFormatException
     * @throws IOException
     */
    private static void checkFiles() throws CsvValidationException, NumberFormatException, IOException {
        boolean check = oldFilesName.equals(newFilesName);
        if (!check) {
            for (int i = 0; i < newFilesName.size(); i++) {
                if (!oldFilesName.contains(newFilesName.get(i))) {
                    FindFlight flight = new FindFlight(
                            "C:/Users/arpitgarg02/eclipse-workspace/AirFlightSystem/bin/Assignment Links/"
                                    + newFilesName.get(i),
                            departureLocation, arrivalLocation, flightDate, flightClass);
                    flight.getFlight();
                }
            }
            oldFilesName = newFilesName;
        }
    }

    @Override
    public void run() {
        while (!checkNewFiles) {
            try {
                getFiles();
                checkFiles();
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (CsvValidationException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * To stop the working when all process is done
     */
    public void threadStop() {
        checkNewFiles = true;
    }

}
