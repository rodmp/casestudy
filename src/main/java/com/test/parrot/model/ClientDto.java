/*
 * Parrot.
 */

package com.test.parrot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto Client definition class.
 * @author parrot.
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

  private Long id;

  /**
   * 
   */
  private String name;
}
