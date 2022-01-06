/*
 * Parrot.
 */

package com.test.parrot.domain;

import java.io.Serializable;
import java.util.List;
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
 * Client definition class.
 * 
 * @author parrot.
 *
 */
@Getter
@Setter
@Table(name = "client")
@Entity
public class Client implements Serializable {

  /**
   * Serializable version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Client id value.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private Long id;

  /**
   * Name client.
   */
  private String name;

  /**
   * Order list.
   */
  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Orders> order;
  
}
