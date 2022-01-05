/*
 * Parrot.
 */

package com.test.parrot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * General config beans.
 * 
 * @author parrot.
 */
@Configuration
public class ApplicationConfig {

  /**
   * Query validated, query params, request params and body params beans.
   * 
   * @return postprocessor del methodvalidation.
   */
  @Bean
  public MethodValidationPostProcessor methodValidationPostProcessor() {
    return new MethodValidationPostProcessor();
  }
}
