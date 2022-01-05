/*
 * Parrot.
 */

package com.test.parrot.api;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.parrot.constant.Constants;
import com.test.parrot.model.ProductReportResponse;
import com.test.parrot.service.ReportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Report controller class.
 * 
 * @author parrot.
 *
 */
@Slf4j
@RequestMapping(Constants.BASE_PATH)
@RestController
public class ReportController {

  /**
   * ReportService variable.
   */
  private final ReportService reportService;

  /**
   * ReportController constructor.
   * 
   * @param reportService ReportService instance.
   */
  public ReportController(final ReportService reportService) {
    this.reportService = reportService;
  }

  /**
   * Get entry point method to generate new report by startDate and endDate filter.
   * 
   * @param page Actual page request.
   * @param size Actual size of page.
   * @param startDate First filter date.
   * @param endDate Second filter date.
   * @return
   */
  @ApiOperation(value = Constants.API_RESOURCES_NAME_REPORTS_CREATE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {@ApiResponse(code = Constants.CODE_OK, message = Constants.OK),
      @ApiResponse(code = Constants.CODE_BAD_REQUEST, message = Constants.BAD_REQUEST),
      @ApiResponse(code = Constants.CODE_INTERNAL_ERROR, message = Constants.INTERNAL_ERROR)})

  @GetMapping(value = Constants.GET_MAPPING_RESOURCE_REPORTS,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductReportResponse> generateReport(
      @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
      @RequestParam("startDate") @DateTimeFormat(
          pattern = "yyyy-MM-dd") Optional<LocalDate> startDate,
      @RequestParam("endDate") @DateTimeFormat(
          pattern = "yyyy-MM-dd") Optional<LocalDate> endDate) {

    log.debug(Constants.END_REQUEST);
    return new ResponseEntity<>(this.reportService.generateReport(page, size, startDate, endDate),
        HttpStatus.OK);
  }

}
