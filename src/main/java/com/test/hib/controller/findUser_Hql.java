package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class findUser_Hql {
    public void findAllUsers() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        // Example for HQL to get all records from user table
        //String hql = "From User";
        String hql = "SELECT u From  User u"; //Same as the above but there is minor difference

        // Step 1 create query interface
        Query q = s.createQuery(hql);

        q.getResultList();
        List<User> ulist = q.getResultList();
        //To print list use for loop
        for (User u : ulist) {
            System.out.println("user id: " + u.getId() + "user " + "user name: " + u.getFullname() + "user city" + u.getCity() + "user email: " + u.getEmail() + "user password: " + u.getPassword());

        }

        f.close();
        s.close();
    }

    public void getRecordbyId() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        String hql = "Select u FROM User u where u.id < 3 ORDER BY u.id DESC ";

        Query q = s.createQuery(hql);
        List<User> ulist = q.getResultList();

        for (User u : ulist) {
            System.out.println("user id: " + u.getId() + "user name: " + u.getFullname() + "user city: " + u.getCity() + "user salary: " + u.getSalary());
        }
        f.close();
        s.close();


    }

    public void getMaxSalaryuser() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        //String hqlQueery =  "Select max(u.salary) from User u";
        // Query q = s.createQuery(hqlQueery);
        //double data = (Double) q.getSingleResult();
        String hql = "Select count(u) from User u";
        Query q = s.createQuery(hql);
        List result = q.getResultList();//List is generic type, it works without "<>" you can pass any type of data
        //returning No(S). List without Wrapper class.
        System.out.println("Max Salary: " + result);
    }

    public void getAllusers(int getuserId) {
        // Demo for Parameterized Query also called prepare statement
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();
        String hql = "Select u FROM User u WHERE u.id = :userid";
        TypedQuery q = s.createQuery(hql);
        q.setParameter("userid", getuserId);
        List<User> ulist = q.getResultList();
        for (User u : ulist) {
            System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: " + u.getEmail() + "|" + "password" + u.getPassword());

        }

    }
}