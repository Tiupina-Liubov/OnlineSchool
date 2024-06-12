package com.example.online_school.configuration;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Configuration class for Liquibase integration.
 */
@Profile("!test")
@Configuration
public class LiquibaseConfig {

    @Value("${spring.liquibase.change-log}")
    private String changeLogPath;

    /**
     * Bean definition for Liquibase.
     *
     * @param dataSource The DataSource for Liquibase to use.
     * @return SpringLiquibase instance.
     */
    @Bean
    @ConditionalOnProperty(prefix = "spring.liquibase", name = "enabled", havingValue = "true")
    public SpringLiquibase liquibase(DataSource dataSource)  {
            SpringLiquibase liquibase = new SpringLiquibase();
            liquibase.setDataSource(dataSource);
            liquibase.setChangeLog(changeLogPath);
            liquibase.setDropFirst(true);
            return liquibase;
        }
    }

