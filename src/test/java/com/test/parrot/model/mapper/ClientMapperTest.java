/*
 * Parrot.
 */

package com.test.parrot.model.mapper;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.test.parrot.domain.Client;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class ClientMapperTest {

  /**
   * 
   */
  @InjectMocks
  private ClientMapper clientMapper;

  /**
   * 
   */
  @Test
  public void clientToClientDtoTest() {
    Client client = new Client();
    client.setId(1l);
    client.setName("user1");
    
    assertNotNull(this.clientMapper.clientToClientDto(client));
  }
}
