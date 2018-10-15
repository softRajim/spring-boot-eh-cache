package com.rajim.ehcache.config;

import com.rajim.ehcache.MainPackage;
import com.rajim.ehcache.settings.DbSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author rajim on 10/14/18
 */
@Slf4j
@Configuration(value = "eh-cacheDataConfig")
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackageClasses = MainPackage.class,
        entityManagerFactoryRef = "eh-cacheEMF", transactionManagerRef = "eh-cacheTM")
public class DataConfig extends AbstractDataConfig {

    private static final String PU_NAME = "eh-cache";
    private static final String DATASOURCE_NAME = "eh-cacheDataSource";
    private static final String[] PACKAGES = {MainPackage.class.getPackage().getName()};

    @Autowired
    @Bean(name = DATASOURCE_NAME)
    public DataSource adminDataSource(DbSettings ehCacheDbSettings) {
        log.info("DB Setting {}", ehCacheDbSettings);
        log.info(ehCacheDbSettings.toString());
        return buildDataSource(ehCacheDbSettings);
    }


    @Primary
    @Bean(name = "eh-cacheEMF")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(value = DATASOURCE_NAME) DataSource dataSource) {
        return buildBackwardEntityManagerFactory(dataSource, PU_NAME, PACKAGES);
    }

    @Primary
    @Bean(name = "eh-cacheTM")
    public PlatformTransactionManager transactionManager(@Qualifier(value = "eh-cacheEMF") EntityManagerFactory emf) {
        return buildTransactionManager(emf);
    }

}
