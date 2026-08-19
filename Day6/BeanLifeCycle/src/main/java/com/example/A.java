package com.example;

import jakarta.annotation.PostConstruct;

public class A {
    B b;

    public A(B b){
        this.b=b;
    }

    @PostConstruct
    public void setB(){
        b.setA(this);
    }
}
