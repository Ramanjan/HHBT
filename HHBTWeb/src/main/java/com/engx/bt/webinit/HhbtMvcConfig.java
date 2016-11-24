package com.engx.bt.webinit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support
.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config
.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Java File. Title : HhbtMvcConfig.java.
 * Description : This config class used for controllers to
 * configuring the view resolver, resource handlers. 
 * 
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

@Configuration
@ComponentScan(basePackages = { "com.engx.bt.*.controller" })
@EnableWebMvc
public class HhbtMvcConfig extends WebMvcConfigurerAdapter{

	/**
     * This is a bean of ViewResolver with default settings.
     *
     * @return internalResourceViewResolver
     */
    @Bean
    public ViewResolver resolver() {
        final InternalResourceViewResolver internalResourceViewResolver =
        new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
    
    /**
     * This is a bean of MultipartResolver with default settings.
     *
     * @return StandardServletMultipartResolver
     */
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
    
    /**
     * This method is used for resource handler.
     * 
     * @see org.springframework.web.servlet.config.annotation.
     * WebMvcConfigurerAdapter
     * #addResourceHandlers(org.springframework.web.servlet.config.
     * annotation. ResourceHandlerRegistry)
     */
    @Override
    public final void
    addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");
    }
    
	/**
	 * This method is used for default servlet handling.
	 *
	 * @see org.springframework.web.servlet.config.annotation
	 *.WebMvcConfigurerAdapter#configureDefaultServletHandling
	 *(org.springframework.web.servlet.config.
	 *annotation.DefaultServletHandlerConfigurer).
	 */
    @Override
    public final void configureDefaultServletHandling(
    final DefaultServletHandlerConfigurer configurer
    ) {
        configurer.enable();
    }
}