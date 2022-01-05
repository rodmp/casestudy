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
import lombok.Getter;
import lombok.Setter;

/**
 * Product definition class.
 * @author parrot.
 *
 */
@Getter
@Setter
@Table(name = "product")
@Entity
public class Product implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;
  
  /**
   * 
   */
  private String name;
  
  /**
   * 
   */
  private BigDecimal price;
  
  /**
   * 
   */
  private Integer stock;
  
  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "order")
  private Set<OrderItem> orders;
}
