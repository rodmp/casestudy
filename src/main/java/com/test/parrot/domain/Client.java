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
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private Long id;

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Orders> order;
  
}
