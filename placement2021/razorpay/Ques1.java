package placement2021.razorpay;

import java.util.*;

public class Ques1 {
    static Scanner in = new Scanner(System.in);

    public static void solve(int[][] A, int q){
        //A[i][0] : price, A[i][1] : rating
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0])); // sort with respect to price
        int n = A.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = A[0][1];
        for (int i = 1; i < n; i++){
            prefixMax[i] = Math.max(prefixMax[i - 1], A[i][1]);
        }

        while(q-- > 0){
            int budget = in.nextInt();
            int left = 0, right = n - 1;
            int loc = -1;

            while(left <= right){
                int mid = left + (right - left) / 2;
                if(A[mid][0] <= budget){
                    loc = mid;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }


            if(loc == -1){
                System.out.println(-1);
            }else{
                System.out.println(prefixMax[loc]);
            }
        }
    }
}
