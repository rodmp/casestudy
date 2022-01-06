/*
 * Parrot.
 */

package com.test.parrot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.parrot.domain.Client;

/**
 * Interface client repository class.
 * 
 * @author parrot.
 *
 */
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

  /**
   * Method to find all clientes.
   */
  Page<Client> findAll(Pageable page);
  
}
