/*
 * Parrot.
 */

package com.test.parrot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.parrot.constant.ApiValues;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger ui class config.
 * 
 * @author parrot.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * Get properties values bean.
   */
  @Autowired
  private ApiValues apiValues;

  /**
   * Generate swagger-ui from existings beans.
   * 
   * @return Docket containing the information to document the API.
   */
  @Bean
  public Docket productApi() {

    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(Boolean.FALSE)
        .select().apis(RequestHandlerSelectors.basePackage(apiValues.getBasePackage()))
        .paths(PathSelectors.any()).build().apiInfo(apiInfo());

  }

  /**
   * Builder to fill in the general API information.
   * 
   * @return ApiInfo containing the API information.
   */
  private ApiInfo apiInfo() {

    return new ApiInfoBuilder().title(apiValues.getTitle())
        .description(apiValues.getDescriptionApi()).version(apiValues.getVersion())
        .contact(new Contact(apiValues.getNameDeveloper(), apiValues.getContactUrl(),
            apiValues.getEmailDeveloper()))
        .build();

  }

}
