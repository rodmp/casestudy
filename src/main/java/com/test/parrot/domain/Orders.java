/*
 * Parrot.
 */

package com.test.parrot.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Order definition class.
 * 
 * @author parrot.
 *
 */
@Getter
@Setter
@Table(name = "orders")
@Entity
public class Orders implements Serializable {

  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Order identifier table.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long id;

  /**
   * Total order price.
   */
  private BigDecimal total;

  /**
   * Order transaction date.
   */
  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  /**
   * Product relation.
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
  private Set<OrderItem> products;

  /**
   * Client relation.
   */
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private Client client;
}
