package com.jb.minetownapi.sevice;

import com.jb.minetownapi.config.JwtTokenProvider;
import com.jb.minetownapi.dto.User;
import com.jb.minetownapi.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String login(User user) {

        try {
            String password = userMapper.selectPassword(user);
            if( passwordEncoder.matches(user.getUserPassword(), password) )
                return jwtTokenProvider.generateToken(user.getUserId());
        }catch(Exception e) {
//            e.printStackTrace();
            log.error(e.getMessage());
        }

        return null;
    }

    public User findUserDtail(String userId) {
        return new User("1", "2");
    }

    public void signUp(User user) {

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        userMapper.insertUser(user);
    }
}
