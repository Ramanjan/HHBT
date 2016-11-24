package com.engx.bt.webinit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support
.PropertySourcesPlaceholderConfigurer;

/**
 * Java File. Title : HhbtAppConfig.java.
 * Description :  This Configuration
 * class used for scan all spring components except controllers and read
 * the configuration information from property files.
 * 
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

@Configuration
@ComponentScan(
basePackages = { "com.engx.bt" },
excludeFilters = @ComponentScan.Filter(
type = FilterType.REGEX, pattern = { "com.engx.bt.*.controller.*" }
)
)
public class HhbtAppConfig {

	/**
     * This is a bean of PropertySourcesPlaceholderConfigurer and 
     * is used for reading the configuration information from
     * property files.
     *
     * @return PropertySourcesPlaceholderConfigurer object
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer
    placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    /**
     * This is a bean of ConcurrentMapCacheManager and is 
     * used for providing the cache manager object.
     *
     * @return ConcurrentMapCacheManager object
     */
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}