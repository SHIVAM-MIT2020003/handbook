package code_jam_2021.qualification_round.B;

import java.util.*;
import java.io.*;

//Programming template
public class Solution {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) return false;
        }
        return true;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans, true);
        ans[1] = false;
        for (int i = 2; i <= n; i++) {
            if (ans[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    ans[j] = false;
                }
            }
        }
        return ans;
    }

    static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++)
            if (((a%m) * (x%m)) % m == 1)
                return x;
        return 1;
    }

    long modPow(int x, int n, int m) {
        if (n == 0) return 1 % m;
        long u = modPow(x, n / 2, m);
        u = (u * u) % m;
        if (n % 2 == 1) u = (u * x) % m;
        return u;
    }

    int max(int ...nums){
        return Arrays.stream(nums).max().getAsInt();
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

    //Main
    public static void main(String[] args) {
        IScanner in = new IScanner();
        int t = in.nextInt();
        int tc = 0;
        while(t-- > 0){
            tc++;
            int X = in.nextInt();
            int Y = in.nextInt();
            char[] s = in.next().toCharArray();
            int N = s.length;
            int[][] dp = new int[2][N];
            dp[0][0] = 0; dp[1][0] = 0;

            for (int i = 1; i < N; i++){
                if(s[i] == '?'){
                    if(s[i - 1] == '?'){
                        dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + Y);
                        dp[1][i] = Math.min(dp[0][i - 1] + X, dp[1][i - 1]);
                    }else{
                        if(s[i - 1] == 'C'){
                            dp[0][i] = dp[0][i - 1];
                            dp[1][i] = dp[0][i - 1] + X;
                        }else{
                            dp[0][i] = dp[1][i - 1] + Y;
                            dp[1][i] = dp[1][i - 1];
                        }
                    }
                }else{
                    if(s[i] == 'C'){
                        if(s[i - 1] == '?'){
                            dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + Y);
                            dp[1][i] = dp[0][i];
                        }else{
                            if(s[i - 1] == 'C'){
                                dp[0][i] = dp[0][i - 1];
                                dp[1][i] = dp[0][i];
                            }else{
                                dp[0][i] = dp[1][i - 1] + Y;
                                dp[1][i] = dp[0][i];
                            }
                        }
                    }else{
                        //?J
                        if(s[i - 1] == '?'){
                            dp[1][i] = Math.min(dp[0][i - 1] + X, dp[1][i - 1]);
                            dp[0][i] = dp[1][i];
                        }else{
                            //CJ
                            if(s[i - 1] == 'C'){
                                dp[1][i] = dp[0][i - 1] + X;
                                dp[0][i] = dp[1][i];
                            }else{
                                //JJ
                                dp[1][i] = dp[1][i - 1];
                                dp[0][i] = dp[1][i];
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + tc +": " + Math.min(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}