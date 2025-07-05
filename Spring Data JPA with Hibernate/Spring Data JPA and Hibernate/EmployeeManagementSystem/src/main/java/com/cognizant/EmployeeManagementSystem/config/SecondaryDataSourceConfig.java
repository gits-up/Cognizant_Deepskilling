package com.cognizant.EmployeeManagementSystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.cognizant.EmployeeManagementSystem.secondary.repository",
    entityManagerFactoryRef = "secondaryEntityManagerFactory",
    transactionManagerRef = "secondaryTransactionManager"
)
public class SecondaryDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.secondary-datasource")
    public DataSourceProperties secondaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource secondaryDataSource() {
        return secondaryDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
        EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(secondaryDataSource())
            .packages("com.cognizant.EmployeeManagementSystem.secondary.model")
            .persistenceUnit("secondary")
            .build();
    }

    @Bean
    public PlatformTransactionManager secondaryTransactionManager(
        final @Qualifier("secondaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean factoryBean) {
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
