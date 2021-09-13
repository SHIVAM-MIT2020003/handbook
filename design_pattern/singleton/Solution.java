package design_pattern.singleton;

class Singleton{
    private static Singleton one;

    private Singleton(){}

    public static Singleton getInstance(){
        if(one == null){
            one = new Singleton();
            return one;
        }else{
            return one;
        }
    }

    public void showMsg(){
        System.out.println("hello world!!");
    }
}


public class Solution {
    public static void main(String[] args) {
        Singleton ob = Singleton.getInstance();
        ob.showMsg();
    }
}

/*
1. mark constructor private
2. define private static field of same class type
3. define public static getInstance method
 */