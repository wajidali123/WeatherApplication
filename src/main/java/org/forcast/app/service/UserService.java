/**
 * 
 */
package org.forcast.app.service;

import java.util.ArrayList;
import java.util.List;

import org.forcast.app.constant.MessagesCode;
import org.forcast.app.dto.UserDto;
import org.forcast.app.entity.UserEntity;
import org.forcast.app.exception.BusinessException;
import org.forcast.app.exception.ForcastException;
import org.forcast.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncripter;
	
	public List<UserDto> getAllUser() throws BusinessException, Exception {
		List<UserEntity> userList = userRepository.findAll();
		List<UserDto> users = new ArrayList<UserDto>();
		if(userList.isEmpty()) {
			throw new ForcastException(MessagesCode.NO_USER_FOUND);
		}
		else {
			userList.forEach((userEntity)->{
				UserDto user = new UserDto();
				user.setId(userEntity.getId());
				user.setName(userEntity.getName());
				user.setEmail(userEntity.getEmail());
				users.add(user);
			});
		}
		return users;
	}
	
	public UserDto registerUser(UserDto userDto) throws BusinessException, Exception {
		UserDto user = new UserDto();
		if(null == userDto.getName() || null == userDto.getEmail() || null == userDto.getPassword()) {
			throw new ForcastException(MessagesCode.USER_DETAILS_MISSING);
		}
		if(userDto.getName().isEmpty() || userDto.getEmail().isEmpty() || userDto.getPassword().isEmpty()) {
			throw new ForcastException(MessagesCode.USER_DETAILS_MISSING);
		}
		else {
			UserEntity userEntity = new UserEntity();
			userEntity.setName(userDto.getName());
			userEntity.setEmail(userDto.getEmail());
			userEntity.setPassword(passwordEncripter.encode(userDto.getEmail()));
			UserEntity userEntitySaved = userRepository.save(userEntity);
			user.setName(userEntitySaved.getName());
		}
		return user;
	}
}
