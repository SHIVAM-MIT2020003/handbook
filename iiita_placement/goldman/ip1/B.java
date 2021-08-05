package iiita_placement.goldman.ip1;

import java.util.Scanner;

public class    B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k =  in.nextInt();
        int[][] a = new int[4][n + 1];
        for(int i = 1;i <= n;i++)
        {
            for(int j = 1;j <= 3;j++)
            {
                a[j][i] = in.nextInt();
            }
        }

        int[][][] dp = new int[n + 1][7][k + 1];
        for(int i = 0;i <= n;i++)
            for(int j = 0;j < 7;j++)
                for(int l = 1;l <= k;l++)
                    dp[i][j][k] = (int)-1e18;
        for(int i = 0;i < 7;i++)
            dp[0][i][0] = 0;
        for(int i = 1;i <= n;i++)
            for(int j = 0;j < 7;j++)
                dp[i][j][0] = 0;
        dp[1][3][1] = a[1][1] + a[2][1];
        dp[1][4][1] = a[2][1] + a[3][1];

        for(int i = 2;i <= n;i++)
        {
            for(int j = 1;j <= k;j++)
            {
                for(int l = 0;l < 7;l++)
                {
                    if(!((l == 1) || (l == 2) || (l == 4)))
                        continue;
                    if(dp[i - 1][l][j - 1] != -1e18)
                        dp[i][0][j] = Math.max(dp[i][0][j], dp[i - 1][l][j - 1] + a[1][i - 1] + a[1][i]);
                    dp[i][0][j] = Math.max(dp[i][0][j], dp[i - 1][0][j]);
                }
                for(int l = 0;l < 7;l++)
                {
                    if(!((l == 0) || (l == 2) || (l == 5)))
                        continue;
                    if(dp[i - 1][l][j - 1] != -1e18)
                        dp[i][1][j] = Math.max(dp[i][1][j], dp[i - 1][l][j - 1] + a[2][i - 1] + a[2][i]);
                    dp[i][1][j] = Math.max(dp[i][1][j], dp[i - 1][1][j]);
                }
                for(int l = 0;l < 7;l++)
                {
                    if(!((l == 1) || (l == 0) || (l == 3)))
                        continue;
                    if(dp[i - 1][l][j - 1] != -1e18)
                        dp[i][2][j] = Math.max(dp[i][2][j], dp[i - 1][l][j - 1] + a[3][i - 1] + a[3][i]);
                    dp[i][2][j] = Math.max(dp[i][2][j], dp[i - 1][2][j]);
                }
                for(int l = 0;l < 7;l++)
                {
                    if(dp[i - 1][l][j - 1] != -1e18)
                        dp[i][3][j] = Math.max(dp[i][3][j], dp[i - 1][l][j - 1] + a[1][i] + a[2][i]);
                    if((j >= 2) && (dp[i - 1][2][j - 2] != -1))
                        dp[i][3][j] = Math.max(dp[i][3][j], dp[i - 1][2][j - 2] + a[1][i - 1] + a[1][i] + a[2][i - 1] + a[2][i]);
                    dp[i][3][j] = Math.max(dp[i][3][j], dp[i - 1][3][j]);
                }
                for(int l = 0;l < 7;l++)
                {
                    if(dp[i - 1][l][j - 1] != -1e18)
                        dp[i][4][j] = Math.max(dp[i][4][j], dp[i - 1][l][j - 1] + a[2][i] + a[3][i]);
                    if((j >= 2) && (dp[i - 1][0][j - 2] != -1))
                        dp[i][4][j] = Math.max(dp[i][4][j], dp[i - 1][0][j - 2] + a[2][i - 1] + a[2][i] + a[3][i - 1] + a[3][i]);
                    dp[i][4][j] = Math.max(dp[i][4][j], dp[i - 1][4][j]);
                }
                for(int l = 0;l < 7;l++)
                {
                    if((j >= 2) && (dp[i - 1][1][j - 2] != -1e18))
                        dp[i][5][j] = Math.max(dp[i][5][j], dp[i - 1][1][j - 2] + a[1][i - 1] + a[1][i] + a[3][i - 1] + a[3][i]);
                    dp[i][5][j] = Math.max(dp[i][5][j], dp[i - 1][5][j]);
                }
                for(int l = 0;l < 7;l++)
                {
                    if((i >= 2) && (j >= 3) && (dp[i - 2][l][j - 3] != -1e18))
                        dp[i][6][j] = Math.max(dp[i][6][j], dp[i - 2][l][j - 3] + a[1][i - 1] + a[1][i] + a[3][i - 1] + a[3][i] + a[2][i - 1] + a[2][i]);
                    dp[i][6][j] = Math.max(dp[i][6][j], dp[i - 1][6][j]);
                }
            }
        }

        int mx = (int)-1e18;
        for(int i = 1;i <= n;i++)
        {
            for(int j = 0;j < 7;j++)
                mx = Math.max(mx, dp[i][j][k]);
        }
        if(mx == -1e18)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(mx);
    }
}


