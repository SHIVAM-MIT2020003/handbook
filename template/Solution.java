package template;

import java.util.*;
import java.io.*;

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
        for (int i = 2; i * i <= n; i++) {
            if (ans[i]) {
                for (int j = i + i; j <= n; j = j + i) {
                    ans[j] = false;
                }
            }
        }
        return ans;
    }

    //iterative
    static long binPow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0)
                res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

    //recursive

    static int max(int ...nums){
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
    static IScanner in = new IScanner();
    static PrintWriter out = new PrintWriter(System.out);
    static Random rand = new Random();
    static void shuffle(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            int j = rand.nextInt(i + 1);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    static void main(String[] args) {
        try {
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void solve(){
        out.flush();
    }
}
