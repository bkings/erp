package model;

import com.model.utility.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class HibernateUtil {

private static SessionFactory sessionFactory;

public static void init() {
    try {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "Manager@123");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
//        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        prop.setProperty("hibernate.show_sql", "true");
        sessionFactory = new Configuration()
                  .addProperties(prop)
                  //your model class
                  .addAnnotatedClass(Tenant.class)
                  .addAnnotatedClass(OrganizationMaster.class)
                  .addAnnotatedClass(OrganizationUser.class)         
                   .addAnnotatedClass(BranchMaster.class)          
                  .buildSessionFactory();
    } catch (Throwable ex) {
        throw new ExceptionInInitializerError(ex);
    }
}

public static Session getSession() {
    return getSessionFactory().openSession();
}

public static SessionFactory getSessionFactory() {
    try {
        if ((sessionFactory.isClosed()) || sessionFactory == null) {
            init();
        }
    } catch (Exception e) {
        init();
    }
    return sessionFactory;
}
}
