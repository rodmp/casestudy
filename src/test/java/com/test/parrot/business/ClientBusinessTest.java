/*
 * Parrot.
 */

package com.test.parrot.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.test.parrot.domain.Client;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.repository.ClientRepository;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class ClientBusinessTest {

  /**
   * 
   */
  @InjectMocks
  private ClientBusiness clientBusiness;

  /**
   * ClientRepository variable.
   */
  @Mock
  private ClientRepository clientRepository;

  @Test
  public void findClientByIdTest() {
    Client client = new Client();
    client.setId(2l);
    client.setName("client1");

    when(this.clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(client));
    assertEquals(client, this.clientBusiness.findClientById(2l));
  }

  @Test
  public void findClientByIdTestNotFound() {
    when(this.clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
    assertThrows(NotDataFoundException.class, () -> this.clientBusiness.findClientById(2l));
  }
}
