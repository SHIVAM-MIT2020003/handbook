package atcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();
        int[][] wp = new int[N][2];

        for (int i = 0; i < N; i++){
            wp[i][0] = in.nextInt();
            wp[i][1] = in.nextInt();
        }

        long[][] dp = new long[N + 1][100001];

        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++){
            dp[i][0] = 0;
        }


        for (int i = 0 ; i < N; i++){
            for (int j = 1; j < dp[i].length; j++){
                dp[i + 1][j] = dp[i][j];
                if(j - wp[i][1] >= 0 && dp[i][j - wp[i][1]] != Integer.MAX_VALUE){
                    dp[i + 1][j] = Math.min(dp[i + 1][j], wp[i][0] + dp[i][j - wp[i][1]]);
                }
            }
        }

        int ans = 0;
        for (int j = dp[0].length - 1; j >= 1; j--){
            if(dp[N][j] <= W){
                ans = j;
                break;
            }
        }

        System.out.println(ans);
    }
}
