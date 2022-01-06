package com.test.parrot.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Product report response definition class.
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
   * Start date filter.
   */
  private String startDate;

  /**
   * End date filter
   */
  private String endDate;

  /**
   * List of products report.
   */
  private List<ProductReport> products;

  /**
   * Total pagination pages.
   */
  private Integer totalPages;

  /**
   * Curren page.
   */
  private Integer currentPage;

  /**
   * Total items.
   */
  private Long totalItems;
}
