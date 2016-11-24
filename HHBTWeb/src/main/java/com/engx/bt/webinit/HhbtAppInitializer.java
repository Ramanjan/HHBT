package com.engx.bt.webinit;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support
.AbstractAnnotationConfigDispatcherServletInitializer;

import com.engx.bt.init.HhbtJPAConfig;

/**
 * Java File. Title : HhbtAppInitializer.java.
 * Description : This Initializer class used for configuring the servlet
 * mvc config, filter and mapping information. Calls the app, jpa config
 * classes to configure those information. 
 * 
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

public class HhbtAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * This method is used for initiate the app, jpa config objects.
	 * @see org.springframework.web.servlet.support
	 * .AbstractAnnotationConfigDispatcherServletInitializer
     * #getRootConfigClasses().
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {
				HhbtAppConfig.class,
				HhbtJPAConfig.class
		};
	}

	/**
	 * This method is used for configuring the mvc.
	 * @see org.springframework.web.servlet.support
	 * .AbstractAnnotationConfigDispatcherServletInitializer
     * #getServletConfigClasses().
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {
				HhbtMvcConfig.class
		};
	}

	/**
	 * This method is used for servlet mappings.
	 * @see org.springframework.web.servlet.support
	 * .AbstractAnnotationConfigDispatcherServletInitializer
     * #getServletMappings().
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	/**
     * This method is used for servlet filter configuration.
     * @see org.springframework.web.servlet.support.
     * AbstractDispatcherServletInitializer #getServletFilters()
     */
    @Override
    public final Filter[] getServletFilters() {
        final CharacterEncodingFilter characterEncodingFilter =
        new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[] { characterEncodingFilter,
        new HiddenHttpMethodFilter(), new MultipartFilter() };
    }
    
    /**
     * This method is used to register the multipart config element.
     * @see org.springframework.web.servlet.support.
     * AbstractDispatcherServletInitializer
     * #customizeRegistration(javax.servlet.ServletRegistration.Dynamic)
     */
    @Override
    public final void customizeRegistration(
    final ServletRegistration.Dynamic registration
    ) {
        final int maxUploadSizeInMb = 5 * 1024 * 1024;
        final MultipartConfigElement multipartConfigElement =
        new MultipartConfigElement(
        null, maxUploadSizeInMb, maxUploadSizeInMb * 2,
        maxUploadSizeInMb / 2
        );
        registration.setMultipartConfig(multipartConfigElement);
    }
}