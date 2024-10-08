package com.himanshu.bankApplication.globalException;

import com.himanshu.bankApplication.exceptions.BusinessException;
import com.himanshu.bankApplication.exceptions.CustomException;
import com.himanshu.bankApplication.exceptions.customerWithNameNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;


@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> NoFoundException(CustomException c){
        return new ResponseEntity<>(c.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(customerWithNameNotFound.class)
    public ResponseEntity<Object> NameNotFoundException(customerWithNameNotFound c){

        return new ResponseEntity<>(c.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BusinessException.class)
public ResponseEntity<Object> IdForDeleteNotFound(BusinessException b){
        BusinessException b1=new BusinessException();

        b1.setErrorCode("120");
        b1.setErrorMessage("Id not found");

        HashMap<String, Object> map = new HashMap<>();
        map.put("ErrorCode",120);
        map.put("ErrorMessage","customer with id not found");
   //     return new ResponseEntity<Object>(b1.getErrorMessage(),HttpStatus.NOT_FOUND);
      return new ResponseEntity<Object>(b1,HttpStatus.NOT_FOUND);
//        return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
//        return new ResponseEntity<Object>("not Found ",HttpStatus.NOT_FOUND);
//
    }
}
