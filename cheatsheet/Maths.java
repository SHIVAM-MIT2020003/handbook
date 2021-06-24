package cheatsheet;

public class Maths {

    //checking whether it is possible to merge k stones into one until we left with one stone
    boolean f(int N, int K){
        if((N - 1) % (K - 1) == 0) return true;
        else return false;
    }
}
