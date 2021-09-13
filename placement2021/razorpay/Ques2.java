package placement2021.razorpay;

import java.util.*;

public class Ques2  {
    public static int solve(int[][] A, int k){
        //A[i][0] : P , A[i][1] : C

        Arrays.sort(A, (a, b) -> Integer.compare(a[1] , b[1])); // sort with respect to 'C'
        Deque<int[]> sw = new ArrayDeque<>();
        sw.add(A[0]);
        int n = A.length;
        int max = 0;
        for (int i = 1; i < n; i++){
            //decreasing deque
            while(!sw.isEmpty() && sw.peek()[1] - A[i][1] > k){
                sw.removeFirst();
            }

            if(!sw.isEmpty()){
                int p1 = A[i][0];
                int p2 = sw.peekFirst()[0];
                int c1 = A[i][1];
                int c2 = sw.peekFirst()[1];
                max = Math.max(max, p1 + p2 + Math.abs(c1 - c2));
            }

            while(!sw.isEmpty() && sw.peekLast()[0] + (A[i][1] - sw.peekLast()[1]) < A[i][0]){
                sw.removeLast();
            }
            sw.add(A[i]);
        }

        return max;
    }
}
