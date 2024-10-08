package com.himanshu.bankApplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BusinessException extends RuntimeException{


    private String errorCode;
    private String errorMessage;

}
