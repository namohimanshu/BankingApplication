package com.himanshu.bankApplication.exceptions;

public class customerWithNameNotFound extends RuntimeException{

    public customerWithNameNotFound(String msg){
        super(msg);
    }

}
