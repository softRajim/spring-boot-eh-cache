package com.rajim.ehcache.settings;

import com.rajim.ehcache.config.AbstractDBSetting;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author rajim on 10/14/18
 */
@Component
@ConfigurationProperties("datasource.eh-cache")
public class DbSettings extends AbstractDBSetting{

}
