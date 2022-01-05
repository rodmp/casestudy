/*
 * Parrot.
 */

package com.test.parrot.business;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.test.parrot.constant.MessageConstant;
import com.test.parrot.domain.Client;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.repository.ClientRepository;
import com.test.parrot.service.ClientService;
import lombok.extern.slf4j.Slf4j;

/**
 * Client business class specification. This class contains one method to find client by id.
 * 
 * @author parrot.
 *
 */
@Slf4j
@Service
public class ClientBusiness implements ClientService {

  /**
   * ClientRepository variable.
   */
  private final ClientRepository clientRepository;

  /**
   * ClientBusiness constructor.
   * 
   * @param clientRepository ClientRepository reference.
   */
  public ClientBusiness(final ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Client findClientById(Long id) {
    Optional<Client> clientDto = this.clientRepository.findById(id);

    if (clientDto.isEmpty()) {
      throw new NotDataFoundException(String.format(MessageConstant.CLIENT_NOT_FOUND, id));
    }
    log.debug(MessageConstant.CLIENT_ID, id);

    return clientDto.get();
  }

}
