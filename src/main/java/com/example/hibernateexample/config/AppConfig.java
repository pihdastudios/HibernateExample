//package com.example.hibernateexample.config;
//
////import antlr.StringUtils;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.example.hibernateexample.entity.Student;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
////import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
////import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import javax.sql.DataSource;
//import java.beans.PropertyVetoException;
//import java.util.Properties;
//
//@Configuration
////@EnableWebMvc
//@EnableTransactionManagement
//@ComponentScan(basePackages = "com.example.hibernateexample")
//@PropertySource({"classpath:application.properties"})
//@Component
////public class AppConfig implements RepositoryRestConfigurer {
//    public class AppConfig {
//
//    // define a bean for ViewResolver
////    @Override
////    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
////        config.exposeIdsFor(Employee.class);
////    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//
//        viewResolver.setPrefix("/WEB-INF/view/");
//        viewResolver.setSuffix(".jsp");
//
//        return viewResolver;
//    }
//
//    @Autowired
//    private Environment env;
//
////	private Logger logger = Logger.getLogger(getClass().getName());
//
//    @Bean
//    public DataSource myDataSource() {
//
//        // create connection pool
//        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
//
//        // set the jdbc driver
//        try {
//            myDataSource.setDriverClass("org.sqlite.JDBC");
//        } catch (PropertyVetoException exc) {
//            throw new RuntimeException(exc);
//        }
//
//        myDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
//
//        return myDataSource;
//    }
//
//    private Properties getHibernateProperties() {
//
//        // set hibernate properties
//        Properties props = new Properties();
//
//        props.setProperty("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
//        props.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//
//        return props;
//    }
//
//
//    // need a helper method
//    // read environment property and convert to int
//
//    private int getIntProperty(String propName) {
//
//        String propVal = env.getProperty(propName);
//
//        // now convert to int
//        assert propVal != null;
//
//        return Integer.parseInt(propVal);
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//
//        // create session factories
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        // set the properties
//        sessionFactory.setDataSource(myDataSource());
//        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
//        sessionFactory.setHibernateProperties(getHibernateProperties());
//        return sessionFactory;
//    }
//
//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//
//        // setup transaction manager based on session factory
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//
//        return txManager;
//    }
//
//}
//
//
//
//
//
//
//
//
//
