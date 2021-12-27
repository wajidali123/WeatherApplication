/**
 * 
 */
package org.forcast.app.service;

import org.forcast.app.constant.MessagesCode;
import org.forcast.app.entity.UserEntity;
import org.forcast.app.exception.BusinessException;
import org.forcast.app.exception.ForcastException;
import org.forcast.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
    private UserRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String name) {
        UserEntity user = null;
		try {
			user = userRepo.finUserByName(name);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return new CustomUserDetails(user);
    }
}
