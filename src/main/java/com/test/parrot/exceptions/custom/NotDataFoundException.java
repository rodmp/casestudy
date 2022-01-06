/*
 * Parrot.
 */

package com.test.parrot.exceptions.custom;

/**
 * Class that represents the exception for when the service cuts the request due to a too long wait
 * for some invoked external service. too long for some invoked external service.
 * 
 * @author.
 */
public class NotDataFoundException extends RuntimeException {

  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = 5141264074683480037L;

  /**
   * Default constructor.
   */
  public NotDataFoundException() {
    super();
  }

  /**
   * Builder receiving an exception to be fired.
   * 
   * @param message custom exception message.
   */
  public NotDataFoundException(String message) {
    super(message);
  }

}
