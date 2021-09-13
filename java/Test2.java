package java;

public class Test2 {
    public static void main(String[] args) {
        new CC();
    }
}

class AA{
    int a = 10;
}

class BB extends AA{
    int a = 20;
}

class CC extends BB{
    int a = 30;
    public CC(){
//        c = super.super.a;   error
//        a  = super.a;
        System.out.println(a);
    }

}

