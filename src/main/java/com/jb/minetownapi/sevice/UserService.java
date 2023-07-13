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
    private final JwtTokenProvider jwtTokenProvider;

    /**
     *
     * @param userMapper 유저관련 처리 매퍼
     */
    public UserService(
            UserMapper userMapper,
            JwtTokenProvider jwtTokenProvider) {

        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     *
     * @param user
     * @return
     */
    public String findUserLogin(User user) {

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

    /**
     *
     * @param userId
     * @return User
     */
    public User findUser(String userId) {
        return new User("1", "2");
    }


    public void addUserRegister(User user) {

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        userMapper.insertUser(user);
    }
}
