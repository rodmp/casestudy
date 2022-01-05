package com.test.parrot.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author parrot.
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductReportResponse {

  /**
   * 
   */
  private String startDate;
  
  /**
   * 
   */
  private String endDate;
  
  /**
   * 
   */
  private List<ProductReport> products;
  
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
