/*
 * Parrot.
 */

package com.test.parrot.exceptions.custom;

import java.util.Collections;
import java.util.List;

/**
 * Class that represents the exception for when the request has incorrect parameters or headers that
 * cannot be processed. that cannot be processed.
 * 
 * @author .
 */
public class BadRequestException extends RuntimeException {

  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = 8925303792177335247L;

  /**
   * List of incorrect fields in the request.
   */
  private final List<String> badFields;

  /**
   * Constructor to initialize the list of incorrect fields.
   * 
   * @param message exception message thrown by bad request.
   * @param badFields list of fields that caused the exception.
   */
  public BadRequestException(String message, List<String> badFields) {
    super(message);
    this.badFields = Collections.unmodifiableList(badFields);
  }

  /**
   * Method to obtain the list of fields.
   * 
   * @return List List of fields.
   */
  public List<String> getBadFields() {
    return badFields;
  }

}
