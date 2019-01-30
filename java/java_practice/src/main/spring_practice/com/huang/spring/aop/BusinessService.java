package com.huang.spring.aop;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    public void say(){
        System.out.println("Business Code");
    }
}