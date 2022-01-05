/*
 * Parrot.
 */

package com.test.parrot.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.parrot.domain.User;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.model.UserRequest;
import com.test.parrot.model.UserResponse;
import com.test.parrot.repository.UserRepository;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class UserBusinessTest {

  /**
   * 
   */
  @InjectMocks
  private UserBusiness userBusiness;
  
  /**
   * userRepository variable.
   */
  @Mock
  private UserRepository userRepository;
  
  /**
   * 
   * @throws Exception
   */
  @Test
  public void findAllUsersTest() throws Exception {
    List<User> users = this.generateListUsers();
    Pageable pageable = PageRequest.of(2, 2);
    Page<User> list = new PageImpl<>(users, pageable, 6);

    when(this.userRepository.findAll(Mockito.any(Pageable.class))).thenReturn(list);

    UserResponse userResponse = this.generateUserResponse();

    assertEquals(userResponse.getUsers().size(),
        this.userBusiness.findAllUsers(Optional.of(2), Optional.of(2)).getUsers().size());

  }

  /**
   * 
   * @throws Exception
   */
  @Test
  public void findAllProductsTestPageEmpty() throws Exception {

    assertThrows(BadRequestException.class,
        () -> this.userBusiness.findAllUsers(Optional.empty(), Optional.of(2)));

  }

  /**
   * 
   * @throws Exception
   */
  @Test
  public void findAllProductsTestPageNull() throws Exception {
    List<User> products = List.of();
    Pageable pageable = PageRequest.of(2, 2);
    Page<User> list = new PageImpl<>(products, pageable, 6);


    when(this.userRepository.findAll(Mockito.any(Pageable.class))).thenReturn(list);

    assertThrows(NotDataFoundException.class,
        () -> this.userBusiness.findAllUsers(Optional.of(2), Optional.of(2)));

  }
  
  /**
   * 
   */
  @Test
  public void createUserTest() {

    User user = new User();
    user.setEmail("test1@gmail.com");
    user.setName("test1");

    when(this.userRepository.save(Mockito.any())).thenReturn(user);

    this.userBusiness.createUser(mock(UserRequest.class));
    assertNotNull(user);
  }

  /**
   * 
   */
  private List<User> generateListUsers()
      throws JsonMappingException, JsonProcessingException {

    String json =
        "[{\"id\":1,\"email\":\"user1@parrot.com.mx\",\"name\":\"User ventas\"},{\"id\":2,\"email\":\"user2@parrot.com.mx\",\"name\":\"User ventas2\"}]";
    return new ObjectMapper().readValue(json, new TypeReference<List<User>>() {});
  }

  /**
   * 
   */
  private UserResponse generateUserResponse()
      throws JsonMappingException, JsonProcessingException {

    String json =
        "{\"users\":[{\"id\":1,\"email\":\"user1@parrot.com.mx\",\"name\":\"User ventas\"},{\"id\":2,\"email\":\"user2@parrot.com.mx\",\"name\":\"User ventas2\"}],\"totalPages\":1,\"currentPage\":0,\"totalItems\":4}";
    return new ObjectMapper().readValue(json, UserResponse.class);
  }
}
