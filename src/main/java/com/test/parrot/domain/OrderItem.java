package com.test.parrot.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Order item definition class.
 * @author parrot.
 *
 */
@Getter
@Setter
@Table(name = "order_item")
@Entity
public class OrderItem implements Serializable {
  
  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Identifier table.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Product relation.
   */
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  /**
   * Order relation.
   */
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "order_id")
  private Orders order;
  
  /**
   * Quantity in order.
   */
  private Integer quantity;

}
