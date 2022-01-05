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
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long id;

  /**
   * 
   */
  private BigDecimal total;

  /**
   * 
   */
  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
  private Set<OrderItem> products;

  /**
   * 
   */
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private Client client;
}
