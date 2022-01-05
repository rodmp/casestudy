/*
 * Parrot.
 */

package com.test.parrot.model.mapper;

import org.springframework.stereotype.Component;
import com.test.parrot.domain.Client;
import com.test.parrot.model.ClientDto;

/**
 * 
 * @author parrot.
 *
 */
@Component
public class ClientMapper {

  /**
   * 
   * @param client
   * @return
   */
  public ClientDto clientToClientDto(Client client) {
    ClientDto clientDto = new ClientDto();
    
    clientDto.setId(client.getId());
    clientDto.setName(client.getName());
    
    return clientDto;
  }
}
