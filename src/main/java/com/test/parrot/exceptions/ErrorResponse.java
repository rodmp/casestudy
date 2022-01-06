/*
 * Parrot.
 */

package com.test.parrot.exceptions;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.parrot.constant.SpecialCharacterConstants;
import lombok.Setter;

/**
 * Error class for controller response.
 */
@Setter
public class ErrorResponse {

  /**
   * Error type.
   */
  private String type;
  /**
   * Error code.
   */
  private String code;
  /**
   * Error details.
   */
  private String details;
  /**
   * Error location.
   */
  private String location;
  /**
   * More info error.
   */
  private String moreInfo;
  /**
   * UUID header.
   */
  private String uuid;
  /**
   * Error time stamp.
   */
  private ZonedDateTime timestamp;

  /**
   * Get Error type Method.
   * 
   * @return type
   */
  public String getType() {
    return type != null ? type : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Get error code method.
   * 
   * @return code
   */
  public String getCode() {
    return code != null ? code : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Get error details method.
   * 
   * @return details
   */
  public String getDetails() {
    return details != null ? details : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Get error location method.
   * 
   * @return location
   */
  public String getLocation() {
    return location != null ? location : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Get error more info method.
   * 
   * @return more info
   */
  public String getMoreInfo() {
    return moreInfo != null ? moreInfo : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Get uuid method.
   * 
   * @return uuid
   */
  public String getUuid() {
    return uuid != null ? uuid : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Get error date in format yyyy-MM-dd'T'HH:mm:ssZ.
   * 
   * @return timestamp
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

}
