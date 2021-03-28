package com.nagarro.flightsystem.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.flightsystem.dao.DatabaseConnection;
import com.nagarro.flightsystem.model.FlightData;

public class DatabaseConnectionImpl implements DatabaseConnection {
    public Session getConnection() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(FlightData.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        return session;
    }
}
