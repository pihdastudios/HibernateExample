package com.example.hibernateexample;

import com.example.hibernateexample.entity.Student;
import lombok.Cleanup;
import org.osgi.util.converter.Converters;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class HibernateExampleApplication {

    public static void main(String[] args) {
//        var context = SpringApplication.run(HibernateExampleApplication.class, args);
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

}
