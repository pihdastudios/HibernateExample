package com.example.hibernateexample.app;

import com.example.hibernateexample.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class PKDemo {

    public static void main(String[] args) {
        var sessionFactory = getSessionFactory();
        var session = sessionFactory.getCurrentSession();


        //Create student obj
        System.out.println("Creating Student");
        var student1 = new Student("Ahmad", "Zidan", "lan666as@mail.com");
        var student2 = new Student("John", "Doe", "JD@mail.com");
        var student3 = new Student("ASD", "fdsa", "fas@mail.com");

        //Start transaction
        session.beginTransaction();

        //Save student obj
        System.out.println("Saving");
        session.save(student1);
        session.save(student2);
        session.save(student3);
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
