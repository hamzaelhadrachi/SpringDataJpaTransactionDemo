package com.zerotohero.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsufficientAmountException extends RuntimeException{
    public InsufficientAmountException(String msg){
        super(msg);
    }
}
