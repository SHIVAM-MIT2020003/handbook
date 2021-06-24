package atcoder.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args) {
        IScanner in = new IScanner();
        int m = in.nextInt();
        int n = in.nextInt();
        char[][] g = new char[m][];
        for (int i = 0; i < m; i++){
            g[i] = in.nextLine().toCharArray();
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1;
        int mod = (int)(1e9+7);
        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if(g[i][j] == '.'){
                    dp[i][j] = (dp[i + 1][j] + dp[i][j + 1]) % mod;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(dp[0][0]);
    }

    static class IScanner {
        BufferedReader br;
        StringTokenizer st;

        public IScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}


