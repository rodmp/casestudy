/*
 * Parrot.
 */

package com.test.parrot.service;

import java.util.Optional;
import com.test.parrot.model.UserRequest;
import com.test.parrot.model.UserResponse;

public interface UserService {

  /**
   * Metood para buscar el total de elementos paginados.
   * @param page Pagina actual.
   * @param size Tamaño de la pagina.
   * @return UserResponse con los elementos encontrados.
   */
  public UserResponse findAllUsers(Optional<Integer> page, Optional<Integer> size);
  
  /**
   * Metodo que sirve para crear un nuevo usuario.
   * @param userRequest Objeto de entrada.
   */
  public void createUser(UserRequest userRequest);
}
