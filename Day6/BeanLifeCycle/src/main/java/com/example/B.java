package com.example;

import org.springframework.stereotype.Component;

@Component
public class B {
    A a;

    public void setA(A a){
        this.a=a;
    }
}
