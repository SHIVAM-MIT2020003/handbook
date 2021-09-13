package java;

import java.util.*;

class P{
    public P(){
        System.out.println("P constructor");
    }


    static
    {
        System.out.println("P static block");
    }


    {
        System.out.println("P instance block");
    }
}

class A extends P {
    static
    {
        System.out.println("A static block");
    }

    {
        System.out.println("A instance block");
    }

    public A(){
        super();
        System.out.println("A Constructor");
    }
}

class Test1 {
    public static void main(String[] args) {
        A a = new A();
    }
}

/*
P static block
A static block
P instance block
P constructor
A instance block
A constructor
 */


//before execution of construction body, instance block is executed



