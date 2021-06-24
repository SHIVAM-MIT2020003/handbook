package atcoder.dp;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        char[] t = in.nextLine().toCharArray();

        int[][] dp = new int[s.length + 1][t.length + 1];

        for (int i = 0; i < s.length; i++){
            for (int j = 0; j < t.length; j++){
                if(s[i] == t[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        StringBuilder ans = new StringBuilder("");

        int i = s.length, j = t.length;
        while(i >= 0 && j >= 0){
            if(i - 1 >= 0 && j - 1 >= 0 && dp[i][j] - 1 == dp[i - 1][j - 1]){
                ans.append(s[i - 1]);
                i--;j--;
            }else if(i - 1 >= 0 && dp[i][j] == dp[i - 1][j]){
                i--;
            }else{
                j--;
            }
        }

        System.out.println(ans.reverse().toString());
    }
}
