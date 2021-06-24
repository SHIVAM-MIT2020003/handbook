package MONK.median_of_two_sorted_array;

public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if(n < m){
            int[] temp = A;
            A = B;
            B = temp;
            int o = m;
            m = n;
            n = o;
        }

        int L = 0, R = m, half = (m + n + 1) / 2;
        while(L <= R){
            int i = L + (R - L) / 2;
            int j = half - i;

            if(i < R && A[i] < B[j - 1]){
                //left part of A should be increased
                L = i + 1;
            }else if(i > 0 && B[j] < A[i - 1]){
                //left part of B should be increased
                R = i - 1;
            }else{
                //perfect i
                int leftMax, rightMin;
                if(i == 0){
                    leftMax = B[j - 1];
                }else if(j == 0){
                    leftMax = A[i - 1];
                }else{
                    leftMax = Math.max(A[i - 1], B[j - 1]);
                }

                if((m + n) % 2 == 1) return leftMax;

                if(i == m){
                    rightMin = B[j];
                }else if(j == n){
                    rightMin = A[i];
                }else{
                    rightMin = Math.min(A[i], B[j]);
                }

                return (leftMax + rightMin) / 2.0;
            }

        }
        return 0.0;
    }
}
