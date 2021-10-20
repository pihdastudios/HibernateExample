package com.example.hibernateexample.app;

import com.example.hibernateexample.entity.Student;
import org.hibernate.cfg.Environment;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class CreateDemo {

    public static void main(String[] args) {
        var sessionFactory = getSessionFactory();
        var session = sessionFactory.getCurrentSession();


        //Create student obj
        System.out.println("Creating Student");
        var student = new Student("Ahmad", "Zidan", "lan666as@mail.com");

        //Start transaction
        session.beginTransaction();

        //Save student obj
        System.out.println("Saving");
        session.save(student);
        session.getTransaction().commit();

        System.out.println("Done");
    }

    public static SessionFactory getSessionFactory() {
        var properties = new Properties();
        properties.put(Environment.DRIVER, "org.sqlite.JDBC");
        properties.put(Environment.DIALECT, "org.sqlite.hibernate.dialect.SQLiteDialect");
        properties.put(Environment.URL, "jdbc:sqlite:/mnt/data/files/Projects/HibernateExample/src/main/resources/database/test-data.db");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        return new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

}
