/*
 * Parrot.
 */

package com.test.parrot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for the mvc web context.
 * 
 * @author parrot.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  /**
   * Bean of constants obtained from the properties file.
   */
  @Autowired
  private com.test.parrot.constant.ApiValues apiValues;

  /**
   * Auto-configuration method to ignore the Media-Type.
   *
   * @param configurer class to configure the Media-Type management strategy.
   */
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    configurer.favorPathExtension(Boolean.TRUE).ignoreAcceptHeader(Boolean.TRUE);

  }

  /**
   * Method to add static resources.
   * 
   * @param registry object that records the resources.
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    registry.addResourceHandler(apiValues.getLabel())
        .addResourceLocations(apiValues.getResourceLocation());

    registry.addResourceHandler(apiValues.getWebjars())
        .addResourceLocations(apiValues.getWebjarsLocation());

    WebMvcConfigurer.super.addResourceHandlers(registry);

  }

}
