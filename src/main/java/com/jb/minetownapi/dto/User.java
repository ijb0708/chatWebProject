package com.jb.minetownapi.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.context.annotation.Primary;

import java.util.Date;

@Data
public class User {
    @NonNull
    private String userId;
    @NonNull
    private String userPassword;
    private Date created_at;
    private Date updated_at;
}
