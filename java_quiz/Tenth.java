package java_quiz;


interface First{
    boolean m1();
    boolean m2();
}

abstract class Second implements First{
    public boolean m1(){
        System.out.println("Second");
        return true;
    }
}

class Third extends Second implements First{
    public Third(){
    }

    public boolean m2(){
        System.out.println("Third");
        return false;
    }
}



public class Tenth {
}
