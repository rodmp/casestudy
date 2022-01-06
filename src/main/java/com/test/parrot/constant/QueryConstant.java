/*
 * Parrot.
 */

package com.test.parrot.constant;

/**
 * Query constant class.
 * 
 * @author parrot.
 *
 */
public class QueryConstant {

  /**
   * Query report string.
   */
  public static final String QUERY_REPORT =
      "SELECT prod.product_id, PROD.NAME, PROD.PRICE, ORDER_ITEM.QUANTITY as stock "
          + "      from orders "
          + "      join  ORDER_ITEM on orders.order_id = order_item.order_id "
          + "      join PRODUCT AS PROD on prod.product_id = order_item.product_id "
          + "      WHERE  orders.transaction_date between :transactionDateStart and :transactionDateEnd "
          + "      GROUP BY PROD.NAME, PROD.PRICE, ORDER_ITEM.QUANTITY "
          + "      ORDER BY ORDER_ITEM.QUANTITY DESC ";

  /**
   * Count query report string.
   */
  public static final String QUERY_REPORT_COUNT = "select count(*) from (\n " + QUERY_REPORT + ")";
}
