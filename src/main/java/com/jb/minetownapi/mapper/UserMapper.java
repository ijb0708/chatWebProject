package com.jb.minetownapi.mapper;

import com.jb.minetownapi.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    
    int insertUser(User user);

    String selectPassword(User user);

    User selectUser(String userId);

}
