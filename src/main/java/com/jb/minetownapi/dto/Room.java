package com.jb.minetownapi.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Room {

    @NonNull
    private String roomName;
    @NonNull
    private String adminUserId;
    
}
