/*
 * Parrot.
 */

package com.test.parrot.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 * Product definition class.
 * 
 * @author parrot.
 *
 */
@Getter
@Setter
@Table(name = "product", uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})})
@Entity
public class Product implements Serializable {

  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Product identifier table.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  /**
   * Product name.
   */
  @Column(unique = true, length = 1000)
  private String name;

  /**
   * Price product.
   */
  private BigDecimal price;

  /**
   * Quantity in stock.
   */
  private Integer stock;

  /**
   * Order list relation.
   */
  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "order")
  private Set<OrderItem> orders;
}
