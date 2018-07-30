package com.kulgeiko.spring_prep.d_data.hibernate;

import com.kulgeiko.spring_prep.d_data.hibernate.dao.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by akulgeiko on 1/8/2018.
 */

@Configuration
@EnableTransactionManagement
public class AppConfig implements TransactionManagementConfigurer {

    // Oracle Datasource
    /*
    @Bean
    public DataSource oracleDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("scott");
        ds.setPassword("1215");
        return ds;
    }
    */


    // HSQL database
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
                .addScript("data/sql/create-db.sql")
                .addScript("data/sql/insert-data.sql")
                .build();
        return db;
    }

    // Session Factory
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

        lsfb.setDataSource(dataSource());
        lsfb.setMappingResources(new String[] {"data/User.hbm.xml"});
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.Oracle10gDialect");
        lsfb.setHibernateProperties(props);
        return lsfb;
    }

    // Platform Transaction Manager
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        //System.out.println(sessionFactory().getObject());
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public UserDAOImpl userDAOImpl(){
        return new UserDAOImpl(sessionFactory().getObject());
    }

}