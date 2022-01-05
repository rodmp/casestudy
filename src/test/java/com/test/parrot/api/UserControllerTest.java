/*
 * Parrot.
 */

package com.test.parrot.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.parrot.model.UserRequest;
import com.test.parrot.model.UserResponse;
import com.test.parrot.service.UserService;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

  /**
   * 
   */
  @InjectMocks
  private UserController userController;

  /**
   * 
   */
  @Mock
  private UserService userService;

  /**
   * 
   * @throws Exception
   */
  @Test
  public void getAllUsersTest() throws Exception {
    UserResponse userResponse = this.generateUserResponse();

    when(this.userService.findAllUsers(Mockito.any(), Mockito.any())).thenReturn(userResponse);

    assertNotNull(this.userController.getAllUsers(Optional.of(0), Optional.of(3)));
  }

  /**
   * 
   */
  @Test
  public void createUsersTest() {
    UserRequest userRequest = mock(UserRequest.class);

    doNothing().when(this.userService).createUser(userRequest);

    assertEquals(HttpStatus.CREATED, this.userController.createUsers(userRequest).getStatusCode());
  }

  private UserResponse generateUserResponse() throws JsonMappingException, JsonProcessingException {

    String json =
        "{\"users\":[{\"id\":1,\"email\":\"user1@parrot.com.mx\",\"name\":\"User ventas\"},{\"id\":2,\"email\":\"user2@parrot.com.mx\",\"name\":\"User ventas2\"},{\"id\":3,\"email\":\"rodo@gmail.com\",\"name\":\"Hernan\"},{\"id\":4,\"email\":\"rodo3@gmail.com\",\"name\":\"Herna3n\"}],\"totalPages\":1,\"currentPage\":0,\"totalItems\":4}";
    return new ObjectMapper().readValue(json, UserResponse.class);
  }
}
