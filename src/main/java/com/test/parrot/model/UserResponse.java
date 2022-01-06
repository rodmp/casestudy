/*
 * Parrot.
 */

package com.test.parrot.model;

import java.util.List;
import com.test.parrot.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User response definition class.
 * 
 * @author parrot.
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {

  /**
   * List users.
   */
  private List<User> users;
  
  /**
   * total pagination pages.
   */
  private Integer totalPages;
  
  /**
   * Current page.
   */
  private Integer currentPage;
  
  /**
   * total items.
   */
  private Long totalItems;
  
}
