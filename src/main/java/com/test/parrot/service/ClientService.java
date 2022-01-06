/*
 * Parrot.
 */

package com.test.parrot.service;

import com.test.parrot.domain.Client;

/**
 * Contract interface Client service class.
 * 
 * @author parrot.
 *
 */
public interface ClientService {

  /**
   * Method to find client by id, if not found and excpetion is thrown {@NotFoundDataException}
   * 
   * @param id Client identifier.
   * @return Client founded.
   */
  Client findClientById(Long id);

}
