package dynamic_programming.maximum_sum_submatrix;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] M = new int[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    M[i][j] = in.nextInt();
                }
            }

            int ans = solve(M);
            System.out.println(ans);
        }
    }

    public static int solve(int[][] M){
        int m = M.length, n = M[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                M[i][j] = M[i][j - 1] + M[i][j];


        int ans = 0;
        for (int c1 = 0; c1 < n; c1++){
            for (int c2 = c1; c2 < n; c2++){
                int cur = 0;
                for (int r = 0; r < m; r++){
                    cur += M[r][c2] - (c1 - 1 >= 0 ? M[r][c1 - 1] : 0);
                    ans = Math.max(ans, cur);
                    cur = Math.max(0, cur);
                }
            }
        }
        return ans;
    }
}



class A
{


}
