package com.heading.examples.model;

import java.io.Serializable;

public class TestClass implements Serializable {

    private static long serialVersionUID = 10L;

    public static String staticAttribute;
    private int atribute1;
    private Boolean atribute2;
    private transient Object transientAttribute;

    private TestClass(){}

    public static TestClass build(){
        return new TestClass();
    }

    public TestClass attribute1(int value){
        this.atribute1 = value;
        return this;
    }

    public TestClass atribute2(Boolean value){
        this.atribute2 = value != null ? value : Boolean.FALSE;
        return this;
    }

    public TestClass transientAttribute(Object value){
        this.transientAttribute = value;
        return this;
    }

    public String toString(){
        return "[attribute1: " + this.atribute1
                + " | attribute2: " + this.atribute2
                + " | transientAttribute: " + this.transientAttribute + "]";
    }
}
