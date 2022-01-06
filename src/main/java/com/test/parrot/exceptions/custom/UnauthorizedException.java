/*
 * Parrot.
 */

package com.test.parrot.exceptions.custom;

/**
 * Class that represents the exception for when a customer is not authorized to perform a specific
 * transaction. specific operation.
 * 
 * @author .
 */
public class UnauthorizedException extends RuntimeException {

  /**
   * UID autogenerado para el versionado de la clase.
   */
  private static final long serialVersionUID = -2122252302133789399L;

  /**
   * Serializable version UID.
   */
  public UnauthorizedException() {
    super();
  }

  /**
   * Constructor that receives the error message to be displayed.
   * 
   * @param message custom exception message.
   */
  public UnauthorizedException(String message) {
    super(message);
  }

  /**
   * Builder receiving an exception to be fired.
   * 
   * @param throwable of exception.
   */
  public UnauthorizedException(Throwable throwable) {
    super(throwable);
  }

}
