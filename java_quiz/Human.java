package java_quiz;


class God{
    static
    {
        System.out.print("b0 ");
    }

    {
        System.out.print("b1 ");
    }

    public God(){
        System.out.print("b2 ");
    }
}

class Animal extends God {
    static{
        System.out.print("r1 ");
    }

    public Animal(){
        //super
        //instance block
        System.out.print("r2 ");
    }

    {
        System.out.print("r3 ");
    }

    static{
        System.out.print("r4 ");
    }
}


class Human extends Animal {
    public static void main(String[] args) {
        System.out.print("p ");

        new Human();

        System.out.print("h ");
    }
}

