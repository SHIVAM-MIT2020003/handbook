package cheatsheet;

public class Array {
    public int upperBound(int[] A, int T){
        int L = 0, R = A.length - 1;
        int B = R + 1;
        while(L <= R){
            int M = L + (R - L) / 2;
            if(A[M] > T){
                B = M;
                R = M - 1;
            }else{
                L = M + 1;
            }
        }
        return B;
    }
}
