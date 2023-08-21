package com.jb.minetownapi.sevice;

import com.jb.minetownapi.config.JwtTokenProvider;
import com.jb.minetownapi.dto.User;
import com.jb.minetownapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 유저의 비밀번호가 옳은지 체크하는 함수
     * @param user 유저계정
     * @return 여부 반환
     */
    public Boolean checkLoginUserPassword(User user) {

        try {
            String password = userMapper.selectOnePassword(user);  // 유저
            return passwordEncoder.matches(user.getUserPassword(), password);
        }catch(Exception e) {
            log.error(e.getMessage());
        }

        return false;
    }
    
    /**
     * 유저의 아이디 유효성(중복) 여부 체크
     * @param userId 유저아이디
     * @return 여부 반환
     */
    public User checkLoginUserId(String userId) {
        
        try {
            return userMapper.selectOneUser(userId); // 유저 검색
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        
        return null;
    }
    
    /**
     * 유저 아이디의
     * @param userId 유저아이디
     * @return 검색한 유저정보
     */
    public Boolean findLoginUserId(String userId) {
        
        try {
            User selectUserData = userMapper.selectOneUser(userId); // 유저 검색
            return selectUserData != null;
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        
        return false;
    }
    
    /**
     * 로그인 정보 토큰 발행 함수
     * @param userId 유저정보
     * @return 토큰 스트링 반환
     */
    public String genLoginUserToken(String userId) {
        try {
            return jwtTokenProvider.generateToken(userId);
        }catch(Exception e) {
            log.error(e.getMessage());
        }
        
        return null;
    }
    
    /**
     * 유저 정보 등록
     * @param user
     */
    public Boolean addUserRegister(User user) {

        try {
            String encodePassword = passwordEncoder.encode(user.getUserPassword());
            user.setUserPassword(encodePassword);
    
            userMapper.insertUser(user);
            return true;
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        
        return false;
    }
}
