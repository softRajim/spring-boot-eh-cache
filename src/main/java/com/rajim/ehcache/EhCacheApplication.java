package com.rajim.ehcache;

import com.rajim.ehcache.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@Import(AppConfig.class)
@SpringBootApplication(scanBasePackageClasses = {MainPackage.class})
@EnableCaching
public class EhCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhCacheApplication.class, args);
	}
}
