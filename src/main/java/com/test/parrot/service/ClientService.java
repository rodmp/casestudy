/*
 * Parrot.
 */

package com.test.parrot.service;

import com.test.parrot.domain.Client;

public interface ClientService {

  /**
   * 
   * @param id
   * @return
   */
  Client findClientById(Long id);

}
