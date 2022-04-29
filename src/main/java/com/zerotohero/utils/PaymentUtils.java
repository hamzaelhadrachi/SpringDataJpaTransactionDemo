package com.zerotohero.utils;

import com.zerotohero.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acct1", 12000.0);
        paymentMap.put("acct2", 10000.0);
        paymentMap.put("acct3", 5000.0);
        paymentMap.put("acct4", 8000.0);
    }

    public static boolean validCreditLimit(String accNo, double paidAmount){

        if (paidAmount > paymentMap.get(accNo)){
            throw new InsufficientAmountException("insufficient Fund...!!");
        }else{
            return true;
        }
    }
}