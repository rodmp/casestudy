/*
 * Parrot.
 */

package com.test.parrot.model;

import javax.validation.constraints.NotBlank;
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
   * User email.
   */
  @NotBlank(message = "Please enter email")
  private String email;

  /**
   * User name.
   */
  @NotBlank(message = "Please enter name")
  private String name;
}
