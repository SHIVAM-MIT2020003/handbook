package atcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = in.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N - 1] = 0;
        for (int i = N - 2; i >= 0; i--){
            for(int j = 1; j <= K && i + j < N; j++){
                dp[i] = Math.min(Math.abs(A[i] - A[i + j]) + dp[i + j], dp[i]);
            }
        }
        System.out.println(dp[0]);
    }
}
