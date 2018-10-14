package com.rajim.ehcache.config;

/**
 * @author rajim on 10/14/18
 */

import com.rajim.ehcache.MainPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Import({DataConfig.class})
@ComponentScan(basePackageClasses = {MainPackage.class,})
@EnableAsync
@EnableScheduling
public class AppConfig {
}
