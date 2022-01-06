/*
 * Parrot.
 */

package com.test.parrot.exceptions.custom;

/**
 * Class that represents the exception for when a client does not have a valid session and is unable
 * to perform a specific operation.
 * 
 * @author.
 */
public class ForbiddenException extends RuntimeException {

  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = -2353346493876392526L;

  /**
   * Default constructor.
   */
  public ForbiddenException() {
    super();
  }

  /**
   * Constructor that receives the error message to be displayed.
   * 
   * @param message custom exception message.
   */
  public ForbiddenException(String message) {
    super(message);
  }

  /**
   * Builder receiving an exception to be fired.
   * 
   * @param throwable exception.
   */
  public ForbiddenException(Throwable throwable) {
    super(throwable);
  }

}
