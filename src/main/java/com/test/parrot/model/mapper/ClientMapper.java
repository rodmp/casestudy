/*
 * Parrot.
 */

package com.test.parrot.model.mapper;

import org.springframework.stereotype.Component;
import com.test.parrot.domain.Client;
import com.test.parrot.model.ClientDto;

/**
 * Cient Mapper class. Component helper to transform objects.
 * 
 * @author parrot.
 *
 */
@Component
public class ClientMapper {

  /**
   * Transform method, client entity to Client dto.
   * 
   * @param client Entity client.
   * @return Client Dto object.
   */
  public ClientDto clientToClientDto(Client client) {
    ClientDto clientDto = new ClientDto();

    clientDto.setId(client.getId());
    clientDto.setName(client.getName());

    return clientDto;
  }
}
