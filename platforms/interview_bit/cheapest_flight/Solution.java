package platforms.interview_bit.cheapest_flight;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1,2,100}, {2,3,100}, {1,3,500}};
        int C = 1;

        int[]ans = new Solution().solve(A, B, C);
        Arrays.stream(ans).forEach(e -> System.out.print(e + " "));
    }
    public int[] findCheapestPrice(int n, int[][] flights, int src, int K) {

        int[][] dp = new int[n][K + 2];

        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int j = 0; j < K + 2; j++){
            dp[src][j] = 0;
        }

        for (int i = 1; i <= K + 1; i++){
            for (int[] f : flights){
                int u = f[0] - 1, v = f[1] - 1, w = f[2];
                if(dp[u][i - 1] != Integer.MAX_VALUE){
                    dp[v][i] = Math.min(dp[v][i], dp[u][i - 1] + w);
                }
            }
        }

        int[] ans = new int[n];
        ans[0] = 0;
        for (int i = 1; i < n; i++){
            ans[i] = dp[i][K + 1] == Integer.MAX_VALUE ? -1 : dp[i][K + 1];
        }
        return ans;
    }

    public int[] solve(int A, int[][] B, int C) {
        int[] ans = findCheapestPrice(A, B, 0, C);
        return ans;
    }
}