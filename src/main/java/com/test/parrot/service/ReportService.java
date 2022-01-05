/*
 * Parrot.
 */

package com.test.parrot.service;

import java.time.LocalDate;
import java.util.Optional;
import com.test.parrot.model.ProductReportResponse;

/**
 * 
 * @author parrot.
 *
 */
public interface ReportService {

  ProductReportResponse generateReport(Optional<Integer> page, Optional<Integer> size,
      Optional<LocalDate> startDate, Optional<LocalDate> endDate);
}
