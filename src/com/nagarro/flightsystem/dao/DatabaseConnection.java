package com.nagarro.flightsystem.dao;

import org.hibernate.Session;

public interface DatabaseConnection {
    public Session getConnection();
}
