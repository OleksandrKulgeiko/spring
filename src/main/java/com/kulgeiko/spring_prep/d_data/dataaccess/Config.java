package com.kulgeiko.spring_prep.d_data.dataaccess;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by akulgeiko on 11/27/2017.
 */

@Configuration
public class Config {

    /*
    // Oracle datasource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("scott");
        ds.setPassword("1215");
        return ds;
    }
    */

    // HSQL datasource
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

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public EmployeeDao getEmployeeDao() {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.setTemplate(getJdbcTemplate());
        return employeeDao;
    }

}
