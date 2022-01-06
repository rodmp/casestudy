/*
 * Parrot.
 */

package com.test.parrot.repository;

import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.test.parrot.constant.QueryConstant;
import com.test.parrot.domain.Product;

/**
 * Interface product repository class.
 * 
 * @author parrot.
 *
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  /**
   * Search all products by request page.
   */
  Page<Product> findAll(Pageable page);

  /**
   * Generate report with specification, initial and end date.
   * @param startDate Initial date.
   * @param endDate End date.
   * @param pageable Object to specify page.
   * @return List of products.
   */
  @Query(value = QueryConstant.QUERY_REPORT, countQuery = QueryConstant.QUERY_REPORT_COUNT,
      nativeQuery = true)
  Page<Product> findByTransactionDateBetween(
      @Param("transactionDateStart") LocalDate transactionDateStart,
      @Param("transactionDateEnd") LocalDate transactionDateEnd, Pageable pageable);
}
