package atcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] A = new int[N][3];
        for (int i = 0; i < N; i++){
            A[i][0] = in.nextInt();
            A[i][1] = in.nextInt();
            A[i][2] = in.nextInt();
        }

        int[][] dp = new int[N][3];
        dp[0][0] = A[0][0];
        dp[0][1] = A[0][1];
        dp[0][2] = A[0][2];
        for (int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + A[i][0];
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][0]) + A[i][1];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + A[i][2];
        }

        System.out.println(Arrays.stream(dp[N - 1]).max().getAsInt());
    }
}
