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

public class BusinessException extends Exception{

    private String errorCode;
    private String errorMessage;

}
