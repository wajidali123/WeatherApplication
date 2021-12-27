/**
 * 
 */
package org.forcast.app;


import static org.assertj.core.api.Assertions.assertThat;

import org.forcast.app.dto.UserDto;
import org.forcast.app.entity.UserEntity;
import org.forcast.app.exception.BusinessException;
import org.forcast.app.repository.UserRepository;
import org.forcast.app.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Wajid Ali
 *
 * Dec 27, 2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void registerUserAndCheckUserInputIsSameAsInsertedValue() throws BusinessException, Exception {
	    // given
	    UserDto user2 = new UserDto();
	    user2.setName("user2");
	    user2.setEmail("user2@gmail.com");
	    user2.setPassword("user2");
	    userService.registerUser(user2);
	    
	    UserEntity found = userRepository.finUserByName(user2.getName());
	   
	    assertThat(found.getName())
	      .isEqualTo(user2.getName());
	}
	
	
}
