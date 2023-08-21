package com.jb.minetownapi;

import com.jb.minetownapi.dto.User;
import com.jb.minetownapi.mapper.UserMapper;
import com.jb.minetownapi.sevice.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MineTownApiApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		User user = new User("test", "test");

//		userService.signUp(user);
//		System.out.println("test:::");
//		System.out.println( userService.login(user) );


	}

}
