package com.piData.emlak.core.payload;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object object;

    public ResponseEntity<?> getResponseJson(ApiResponse apiResponse){
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public ApiResponse(){}

    public ApiResponse(Boolean success, String message, Object o) {
        this.success = success;
        this.message = message;
        this.object = o;
    }
}
