package com.test.hib.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateUserTable {
    public static void main(String[] args) {

        //Configuration cfg = new Configuration(); //Activate Connection
       // Configuration c = cfg. configure(); // Looking for hibernate.cfg.xm for db information
       // SessionFactory f = c.buildSessionFactory(); // Return a database connection

        //Short cut
        SessionFactory f = new Configuration().configure().buildSessionFactory();

        Session s = f.openSession(); // Create a session for available connection.
        //Transaction is responsible for executing SQL, how to save. Just dealing with
        //Creating tables and no need for Transaction
       // Transaction t = s.beginTransaction();

    }
}
