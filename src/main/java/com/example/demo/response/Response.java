/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Iva
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class Response {
    
    private String message;
    private Map<?, ?> data;
    private HttpStatus status;
    
    public Response(String message, HttpStatus httpStatus){
        this.message = message;
        this.status = httpStatus;
    }
    
}
