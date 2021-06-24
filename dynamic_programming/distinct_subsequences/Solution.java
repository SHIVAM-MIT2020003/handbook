package dynamic_programming.distinct_subsequences;

/*
Interview bit
Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
 */


//cou nting

public class Solution {
    public int numDistinct(String s1, String s2) {
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();
        int m = A.length, n = B.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++){
            dp[0][j] = 1;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(B[i] == A[j]){
                    //dp[i + 1][j + 1] = include(j) + exclude(j)
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                }else{
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[n][m];
    }
}

