/*
 * Parrot.
 */

package com.test.parrot.business;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.test.parrot.constant.MessageConstant;
import com.test.parrot.domain.Product;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.model.ProductReport;
import com.test.parrot.model.ProductReportResponse;
import com.test.parrot.repository.ProductRepository;
import com.test.parrot.service.ReportService;
import lombok.extern.slf4j.Slf4j;

/**
 * Report business class. This class create new report by startDate and endDate filters.
 * 
 * @author parrot.
 *
 */
@Slf4j
@Service
public class ReportBusiness implements ReportService {

  /**
   * ProductRepository variable.
   */
  private final ProductRepository orderRepository;

  /**
   * ReportBusiness constructor.
   * 
   * @param orderRepository ProductRepository reference.
   */
  public ReportBusiness(final ProductRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ProductReportResponse generateReport(Optional<Integer> page, Optional<Integer> size,
      Optional<LocalDate> startDate, Optional<LocalDate> endDate) {

    if (page.isEmpty() || size.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
      throw new BadRequestException(MessageConstant.PAGE_SIZE_NOT_NULL,
          List.of(MessageConstant.PAGE, MessageConstant.SIZE, MessageConstant.STARTDATE,
              MessageConstant.ENDDATE));
    }

    Pageable pageable = PageRequest.of(page.get(), size.get());

    Page<Product> optionalOrders =
        this.orderRepository.findByTransactionDateBetween(startDate.get(), endDate.get(), pageable);

    if (optionalOrders.getContent().isEmpty()) {
      throw new NotDataFoundException(MessageConstant.ORDER_NOT_FOUND);
    }

    ProductReportResponse productReportResponse = new ProductReportResponse();
    productReportResponse.setEndDate(endDate.get().toString());
    productReportResponse.setStartDate(startDate.get().toString());
    productReportResponse.setCurrentPage(page.get());
    productReportResponse.setTotalItems(optionalOrders.getTotalElements());
    productReportResponse.setTotalPages(optionalOrders.getTotalPages());

    productReportResponse.setProducts(new ArrayList<>());
    log.debug(MessageConstant.LOG_ORDERS, optionalOrders);

    productReportResponse.getProducts().addAll(optionalOrders.getContent().stream()
        .map(productDto -> this.generateProductReport(productDto)).collect(Collectors.toList()));

    return productReportResponse;
  }

  /**
   * Private method to create new product report, this represents the output of the columns product
   * name, quantity and total sold.
   * 
   * @param orderItem
   * @return
   */
  private ProductReport generateProductReport(Product orderItem) {

    ProductReport productReport = new ProductReport();
    productReport.setName(orderItem.getName());
    productReport.setQuantity(orderItem.getStock());
    productReport.setTotal(orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getStock())));

    return productReport;
  }
}
