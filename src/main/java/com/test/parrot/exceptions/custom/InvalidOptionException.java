/*
 * Parrot.
 */

package com.test.parrot.exceptions.custom;

/**
 * Class that represents the exception for when the service receives an incorrect option within the
 * expected request. expected request.
 * 
 * @author.
 */
public class InvalidOptionException extends RuntimeException {

  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = 2920243542505819515L;

  /**
   * Default constructor.
   */
  public InvalidOptionException() {
    super();
  }

  /**
   * Constructor that receives the error message to be displayed.
   * 
   * @param message custom exception message.
   */
  public InvalidOptionException(String message) {
    super(message);
  }

  /**
   * Builder receiving an exception to be fired.
   * 
   * @param throwable de la excepción.
   */
  public InvalidOptionException(Throwable throwable) {
    super(throwable);
  }

}
