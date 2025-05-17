package org.prog.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
@EnableJpaRepositories("org.prog")
@Configuration
@EnableWebMvc
@ComponentScan("org.prog")
public class ApplicationConfiguration {

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dmds =
                new DriverManagerDataSource(getSQLHost(), "root", "password");
        dmds.setDriverClassName("com.mysql.jdbc.Driver");
        dmds.setSchema("db");
        return dmds;
    }

    private String getSQLHost() {
        return "jdbc:mysql://demo-sql:3306/db";
    }
}
