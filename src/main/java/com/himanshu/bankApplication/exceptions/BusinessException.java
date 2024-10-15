package com.himanshu.bankApplication.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter

@AllArgsConstructor
@JsonIgnoreProperties({"cause", "stackTrace", "suppressed", "message", "localizedMessage"})
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
public BusinessException(){

    super();
}
//    public Throwable fillInStackTrace() {
//        return this;  // Prevent stack trace generation
//    }
//    @JsonIgnore
//    public Throwable getCause() {
//        return super.getCause();
//    }
//
//    @Override
//    @JsonIgnore
//    public StackTraceElement[] getStackTrace() {
//        return super.getStackTrace();
//    }
//
//    @Override
//    @JsonIgnore
//    public String getMessage() {
//        return super.getMessage();
//    }
//
//    @Override
//    @JsonIgnore
//    public String getLocalizedMessage() {
//        return super.getLocalizedMessage();
//    }
//public Throwable [] getSuppressed(){
    // can not override because his method is final in Throwable class
//     return
//this.getSuppressed();
//}
}
