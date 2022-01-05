/*
 * Parrot.
 */

package com.test.parrot.business;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.test.parrot.constant.MessageConstant;
import com.test.parrot.domain.User;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.model.UserRequest;
import com.test.parrot.model.UserResponse;
import com.test.parrot.repository.UserRepository;
import com.test.parrot.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * User business class. This class contains operations to get all users and create new users.
 * 
 * @author parrot.
 *
 */
@Slf4j
@Service
public class UserBusiness implements UserService {

  /**
   * userRepository variable.
   */
  private final UserRepository userRepository;

  /**
   * UserBusiness constuctor.
   * 
   * @param userRepository UserRepository reference.
   */
  public UserBusiness(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public UserResponse findAllUsers(Optional<Integer> page, Optional<Integer> size) {
    if (page.isEmpty() || size.isEmpty()) {
      throw new BadRequestException(MessageConstant.PAGE_SIZE_NOT_NULL,
          List.of(MessageConstant.PAGE, MessageConstant.SIZE));
    }

    Pageable pageable = PageRequest.of(page.get(), size.get());
    Page<User> list = this.userRepository.findAll(pageable);

    if (list.getContent().isEmpty()) {
      throw new NotDataFoundException(MessageConstant.USER_NOT_FOUND);
    }

    log.debug(MessageConstant.LOG_USERS, list.getContent());
    UserResponse userResponse = new UserResponse();
    userResponse.setCurrentPage(page.get());
    userResponse.setTotalItems(list.getTotalElements());
    userResponse.setTotalPages(list.getTotalPages());
    userResponse.setUsers(list.getContent());

    return userResponse;
  }

  /**
   * {@inheritDoc}
   */
  @Transactional
  @Override
  public void createUser(UserRequest userRequest) {
    User user = new User();
    user.setEmail(userRequest.getEmail());
    user.setName(userRequest.getName());

    log.debug(MessageConstant.LOG_SAVE_USER);
    this.userRepository.save(user);
  }
}
