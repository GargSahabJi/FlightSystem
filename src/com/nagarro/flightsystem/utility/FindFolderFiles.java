/*
* Class name: FindFolderFiles
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
* Description: Find the all files in the given folder
*/
package com.nagarro.flightsystem.utility;

import java.io.File;
import java.util.ArrayList;

public class FindFolderFiles {
    private static final String C_USERS_ARPITGARG02_ECLIPSE_WORKSPACE_AIR_FLIGHT_SYSTEM_BIN_RESOURCES = "C:\\Users\\arpitgarg02\\eclipse-workspace\\AirFlightSystem\\bin\\resources";
    private static ArrayList<String> filesName = new ArrayList<>();

    /**
     * @return list of all files in the given folder
     */
    public ArrayList<String> getAllFiles() {
        try {
            File folder = new File(C_USERS_ARPITGARG02_ECLIPSE_WORKSPACE_AIR_FLIGHT_SYSTEM_BIN_RESOURCES);
            for (File file : folder.listFiles()) {
                String name = file.getName();
                if (!filesName.contains(name)) {
                    filesName.add(name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filesName;
    }

}