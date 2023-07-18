package com.jb.minetownapi.dto;

import lombok.Data;

@Data
public class result {
    private int code;
    private String message;
    
    public result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
