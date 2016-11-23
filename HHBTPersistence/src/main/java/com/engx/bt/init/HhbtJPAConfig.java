package com.engx.bt.init;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Java File. Title : HhbtJPAConfig.java.
 * Description : This Configuration class is used for configuring
 * the datasource, entity manager and transaction manager. 
 * 
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "hhbtEntityManager",
transactionManagerRef = "hhbtTxManager",
basePackages = { "com.engx.bt.repository" })
@PropertySource("classpath:hhbtdb.properties")
public class HhbtJPAConfig {
	
	/**
     * PROPERTY_NAME_DATABASE_DRIVER.
     */
    private static final String PROPERTY_NAME_DATABASE_DRIVER =
    "db.hhbt.driver";
    /**
     * PROPERTY_NAME_DATABASE_USERNAME.
     */
    private static final String PROPERTY_NAME_DATABASE_USERNAME =
    "db.hhbt.username";
    /**
     * PROPERTY_NAME_DATABASE_PASSWORD.
     */
    private static final String PROPERTY_NAME_DATABASE_PASSWORD =
    "db.hhbt.password";
    /**
     * PROPERTY_NAME_DATABASE_URL.
     */
    private static final String PROPERTY_NAME_DATABASE_URL = "db.hhbt.url";
    /**
     * PROPERTY_NAME_HIBERNATE_DIALECT.
     */
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT =
    "hibernate.dialect";
    /**
     * PROPERTY_NAME_HIBERNATE_SHOW_SQL.
     */
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL =
    "hibernate.show_sql";
    /**
     * PROPERTY_NAME_HIBERNATE_GENERATED_KEYS.
     */
    private static final String PROPERTY_NAME_HIBERNATE_GENERATED_KEYS =
    "jdbc.use_get_generated_keys";
    /**
     * PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN.
     */
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN =
    "hhbt.packages.to.scan";
    
    /**
     * Environment.
     */
    @Autowired
    private transient Environment environment;
    
    /**
     * This is a bean of DataSource to use for configure the datasource.
     *
     * @return DataSource
     */
    @Bean
    public DataSource hhbtDataSource() {
        final DriverManagerDataSource hhbtDataSource =
        new DriverManagerDataSource();
        hhbtDataSource.setDriverClassName(
        environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER)
        );
        hhbtDataSource
        .setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        hhbtDataSource.setUsername(
        environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME)
        );
        hhbtDataSource.setPassword(
        environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD)
        );
        return hhbtDataSource;
    }
    
    /**
     * This method used for configuring the local entity manager factory
     * bean.
     *
     * @return hhbtEntityManagerFactoryBean
     */
    @Bean(name = "hhbtEntityManager")
    public LocalContainerEntityManagerFactoryBean
    hhbtEntityManagerFactory() {
        /**
         * creating the new hhbtEntityManager object and set the values
         * like data source and provider class. finally returning the
         * values.
         */
        final LocalContainerEntityManagerFactoryBean 
        hhbtEntityManagerFactoryBean = 
        new LocalContainerEntityManagerFactoryBean();
        hhbtEntityManagerFactoryBean.setDataSource(hhbtDataSource());
        hhbtEntityManagerFactoryBean
        .setPersistenceProviderClass(HibernatePersistenceProvider.class);
        hhbtEntityManagerFactoryBean
        .setPackagesToScan(
        		environment
        .getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN)
        );
        
        hhbtEntityManagerFactoryBean.setJpaProperties(HhbtHibProperties());
        hhbtEntityManagerFactoryBean.setPersistenceUnitName("hhbtEm");
        return hhbtEntityManagerFactoryBean;
    }
    
    /**
     * This method is used for configuring the hibernate propeties.
     *
     * @return properties
     */
    private final Properties HhbtHibProperties() {
        /**
         * creating the new Properties object and set the values like
         * required property values.
         */
        final Properties properties = new Properties();
        properties.put(
        PROPERTY_NAME_HIBERNATE_DIALECT,
        environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT)
        );
        properties.put(
        PROPERTY_NAME_HIBERNATE_SHOW_SQL,
        environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL)
        );
        properties.put(
        PROPERTY_NAME_HIBERNATE_GENERATED_KEYS,
        environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_GENERATED_KEYS)
        );
        return properties;
    }
    
    /**
     * This is a bean of JpaTransactionManager to use for initialize
     * the transaction manager bean.
     *
     * @return JpaTransactionManager
     */
    @Bean(name = "hhbtTxManager")
    @Qualifier(value = "hhbt")
    public JpaTransactionManager hhbtTransactionManager() {
    	/**
         * creating the new Properties object and set the values like
         * entity manager factory value.
         */
        final JpaTransactionManager hhbtTransactionManager =
        new JpaTransactionManager();
        hhbtTransactionManager
        .setEntityManagerFactory(hhbtEntityManagerFactory().getObject());
        return hhbtTransactionManager;
    }
}