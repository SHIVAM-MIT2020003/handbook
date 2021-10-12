package placement2021.chalo;

import java.util.Arrays;
import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int[][] A = new int[n][];

            for (int i = 0; i < n; i++){
                int d = in.nextInt();
                int r = in.nextInt();
                int s = in.nextInt();
                A[i] = new int[]{d, r, s};
            }

            Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));

            int[][] dp = new int[n][1001];

//            (deadline, reward, time)
            for (int j = 1; j <= 1000; j++){
                if(A[0][0] <= j && j - A[0][2] >= 0){
                    dp[0][j] = A[0][1];
                }
            }


            for (int i = 1; i < n; i++){
                for (int j  = 1; j <= 1000; j++){
                    if(A[i][0] <= j){
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i][2]] + A[i][1]);
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < 1001; i++){
                ans = Math.max(ans, dp[n - 1][i]);
            }
            System.out.println(ans);
        }
    }
}
