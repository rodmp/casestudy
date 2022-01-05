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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {

  /**
   * 
   */
  private List<User> users;
  
  /**
   * 
   */
  private Integer totalPages;
  
  /**
   * 
   */
  private Integer currentPage;
  
  /**
   * 
   */
  private Long totalItems;
  
}
