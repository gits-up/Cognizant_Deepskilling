package com.cognizant.EmployeeManagementSystem.config;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.cognizant.EmployeeManagementSystem.repository",
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDataSourceConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
        EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(dataSource)
            .packages("com.cognizant.EmployeeManagementSystem.model")
            .persistenceUnit("primary")
            .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager primaryTransactionManager(
        @Qualifier("primaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean factoryBean) {
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
