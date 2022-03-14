package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CreatingUser {
    public static void main(String[] args) {

        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        Transaction t =  s.beginTransaction();

        User uOne = new User();
        uOne.setAge(20);
        uOne.setCity("NYC");
        uOne.setEmail("XYZ@YAHOO.COM");
        uOne.setFullname("Iqbal Ahmed");
        uOne.setPassword("password466");
        uOne.setSalary(30000);

        User uTwo = new User();
        uTwo.setAge(30);
        uTwo.setFullname("Ali Weerax");
        uTwo.setEmail("sdd@gmail.com");
        uTwo.setSalary(20000);
        uTwo.setCity("Saint Cloud");

        User uThree = new User();
        uThree.setAge(55);
        uThree.setCity("Minneapolis");
        uThree.setEmail("Ham@hotmail.com");
        uThree.setFullname("Faisal Abdulle");
        uThree.setPassword("passw6");
        uThree.setSalary(30000);

        User uFour = new User();
        uFour.setAge(55);
        uFour.setCity("Minnea");
        uFour.setEmail("Ham@hotmil.com");
        uFour.setFullname("Faisal Abdule");
        uFour.setPassword("pasw6");
        uFour.setSalary(3000);


        s.save(uOne); // equal to insert into table
        s.save(uTwo); // equal to insert into table value
        s.save(uThree);
        s.save(uFour);
        t.commit();
        System.out.println("Data is successfully inserted in user table");

        f.close();
        s.close();

    }


    }
