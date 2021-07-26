package placement2021.D_E_Shaw;

import java.util.*;

public class A {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {2,1,4};
        int[] C = {1,2,3};
        System.out.println(solve(A, B, C));
    }

    public static long solve(int[] A, int[] B, int[] C){
        int[] a = new int[7];
        int[] b = new int[7];
        int[] c = new int[7];

        for (int i = 0; i < A.length; i++){
            a[A[i] % 7]++;
        }

        for (int i = 0; i < B.length; i++){
            b[B[i] % 7]++;
        }

        for (int i = 0; i < C.length; i++){
            c[C[i] % 7]++;
        }

        long ans = 0;
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                for (int k = 0; k < 7; k++){
                    if((i + j + k) % 7 == 0){
                        ans += a[i] * b[j]  * c[k];
                    }
                }
            }
        }

        return ans;
    }
}
