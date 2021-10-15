package com.example.hibernateexample;

import com.example.hibernateexample.entity.Student;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class HibernateExampleApplication {

    public static void main(String[] args) {
//        SpringApplication.run(HibernateExampleApplication.class, args);
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

}
