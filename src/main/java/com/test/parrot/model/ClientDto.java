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
 * 
 * @author parrot.
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

  /**
   * client Identifier.
   */
  private Long id;

  /**
   * Client name.
   */
  private String name;
}
