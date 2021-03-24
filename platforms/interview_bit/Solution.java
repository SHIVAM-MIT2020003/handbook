package platforms.interview_bit;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa"));
    }
    public int numDistinct(String A, String B) {
        String temp = A;
        A = B;
        B = A;

        int m = A.length(), n = B.length();
        int[][] dp = new int[m][n];
        if(A.charAt(0) == B.charAt(0))
            dp[0][0] = 1;
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0];
            if(A.charAt(i) == B.charAt(0))
                dp[i][0] += 1;
        }

        for (int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1];
            if(A.charAt(0) == B.charAt(j))
                dp[0][j] += 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if(A.charAt(i) == B.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m - 1][n - 1];
    }
}
