/*
 * Parrot.
 */

package com.test.parrot.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * Class containing the externalized values of the API(s).
 * 
 * @author .
 */
@Component
@Getter
public class ApiValues {

  /**
   * Externalized value to indicate the base package of the project.
   */
  @Value("${constants.swagger.basePackage}")
  private String basePackage;

  /**
   * Externalized value to indicate the API title.
   */
  @Value("${constants.swagger.title}")
  private String title;

  /**
   * Externalized value to indicate the API description.
   */
  @Value("${constants.swagger.descriptionApi}")
  private String descriptionApi;

  /**
   * Externalized value to indicate the swagger version.
   */
  @Value("${constants.swagger.version}")
  private String version;

  /**
   * Externalized value to indicate the name of the developer.
   */
  @Value("${constants.swagger.nameDeveloper}")
  private String nameDeveloper;

  /**
   * Externalized value to indicate the URL of the request.
   */
  @Value("${constants.swagger.contactUrl}")
  private String contactUrl;

  /**
   * Externalized value to indicate the developer's email.
   */
  @Value("${constants.swagger.emailDeveloper}")
  private String emailDeveloper;

  /**
   * Externalized value to indicate the swagger tags.
   */
  @Value("${constants.swagger.label}")
  private String label;

  /**
   * Externalized value to indicate the resource to be consumed.
   */
  @Value("${constants.swagger.resourceLocation}")
  private String resourceLocation;

  /**
   * Externalized value to indicate where swagger artifacts are generated.
   */
  @Value("${constants.swagger.webjars}")
  private String webjars;

  /**
   * Externalized value to indicate the location of the artifacts.
   */
  @Value("${constants.swagger.webjarsLocation}")
  private String webjarsLocation;

  /**
   * Private constructor to avoid the instance of this class.
   */
  private ApiValues() {

  }

}
