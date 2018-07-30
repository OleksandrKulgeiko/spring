package com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories("com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository")
public class SpringDataJpaConfig {
  
  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .addScript("transactions/create-table.sql")
        .addScript("classpath:/com/habuma/spitter/db/jpa/config-data.sql")
        .build();
  }
  
  @Bean
  public JpaTransactionManager transactionManager() {
    return new JpaTransactionManager(); // does this need an emf???
  }
  
  @Bean
  public HibernateJpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.H2);
    adapter.setShowSql(false);
    adapter.setGenerateDdl(true);
    return adapter;
  }
  
  @Bean
  public Object emf() {
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource());
    emf.setPersistenceUnitName("spitter");
    emf.setJpaVendorAdapter(jpaVendorAdapter());
    return emf;
  }
  
}
