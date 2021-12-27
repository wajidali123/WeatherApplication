package org.forcast.app;

import org.forcast.app.entity.UserEntity;
import org.forcast.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@PropertySources({
	@PropertySource("classpath:message.properties")
})
public class WeatherApplication implements CommandLineRunner {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
		UserEntity admin = new UserEntity(1, "admin", "admin@gmail.com", passwordEncoder.encode("admin"));
		userRepository.save(admin);	

	}
}
