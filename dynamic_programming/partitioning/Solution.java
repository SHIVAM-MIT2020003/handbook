package dynamic_programming.partitioning;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int size = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = in.nextInt();
        }

        int ans = solve(nums, n, size);
        System.out.println(ans);
    }

    public static int solve(int[] nums, int n, int size){
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = nums[i];
        }

        for (int L = n - 2; L >= 0; L--){
            for (int R = L + 1; R < n; R++){
                for (int k = L; k <= R; k++){
                    //left grouping
                    int max = nums[k];
                    for (int l = k; l >= L && k - l + 1 <= size; l--){
                        max = Math.max(max, nums[l]);
                        dp[L][R] = Math.max(dp[L][R], ((l - 1 < L) ? 0 : dp[L][l - 1])
                                + (k + 1 > R ? 0 : dp[k + 1][R]) + (k - l + 1) * max);
                    }

                    //right grouping
                    if(k + 1 <= R) {
                        max = nums[k];
                        for (int r = k + 1; r <= R && r - k + 1 <= size; r++) {
                            max = Math.max(max, nums[r]);
                            dp[L][R] = Math.max(dp[L][R], (k - 1 < L ? 0 : dp[L][k - 1])
                                    + (r + 1 > R ? 0 : dp[r + 1][R]) + (r - k + 1) * max);
                        }
                    }
                }
            }
        }
//
//        for (int i = 0; i < dp.length; i++){
//            for (int j = 0; j < dp[i].length; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[0][n - 1];
    }
}