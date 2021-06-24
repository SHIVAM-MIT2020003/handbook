package atcoder.dp;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();
        int[][] wp = new int[N][2];
        for (int i = 0; i < N; i++){
            wp[i][0] = in.nextInt();
            wp[i][1] = in.nextInt();
        }

        long[] dp = new long[W + 1];
        for (int i = 0 ; i < N; i++){
            for (int j = W; j >= wp[i][0]; j--){
                dp[j] = Math.max(dp[j], wp[i][1] + dp[j - wp[i][0]]);
            }
        }
        System.out.println(dp[W]);
    }
}
