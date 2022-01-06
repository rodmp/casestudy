/*
 * Parrot.
 */

package com.test.parrot.service;

/**
 * Contract interface Report service class.
 * 
 * @author parrot.
 *
 */
import java.time.LocalDate;
import java.util.Optional;
import com.test.parrot.model.ProductReportResponse;

/**
 * 
 * @author parrot.
 *
 */
public interface ReportService {

  /**
   * Generate report method. This method receives 4 parameters, the page number, the page size for
   * the page and two dates as a filter, a start date and an end date. The search of the orders is
   * done by these parameters and the orders and products found are returned sorted from highest to
   * lowest according to the requested quantity of each product.
   * 
   * @param page
   * @param size
   * @param startDate
   * @param endDate
   * @return
   */
  ProductReportResponse generateReport(Optional<Integer> page, Optional<Integer> size,
      Optional<LocalDate> startDate, Optional<LocalDate> endDate);
}
