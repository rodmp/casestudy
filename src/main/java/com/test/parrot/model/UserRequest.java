/*
 * Parrot.
 */

package com.test.parrot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User request definition.
 * 
 * @author parrot.
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

  /**
   * 
   */
  private String email;

  /**
   * 
   */
  private String name;
}
