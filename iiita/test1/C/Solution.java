package iiita.test1.C;

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

    static List<Integer> factors(int n){
        List<Integer> ans = new ArrayList<>();
        // If there is factor then it must be less than equal to sqrt(n)
        for (int x = 2; x * x <= n; x++){
            while(n % x == 0){
                ans.add(x);
                n = n / x;
            }
        }
        //if n becomes prime after some factorization then will be no factor other than self
        if(n > 1) ans.add(n);
        return ans;
    }


    //Main
    public static void main(String[] args) {
        IScanner in = new IScanner();
        int t = in.nextInt();
        while(t-- > 0){
            int N = in.nextInt();
            int Q = in.nextInt();
            long[] A = new long[N + 1];
            int[] minL = new int[N + 1];
            int[] minR = new int[N + 1];
            int[] maxL = new int[N + 1];
            int[] maxR = new int[N + 1];
            int[] nums = new int[N];
            long total = 0l;
            for (int i = 0; i < N; i++){
                nums[i] = in.nextInt();
                total += nums[i];
            }

            for (int i = 0; i < N; i++){
                A[i + 1] = A[i] + nums[i];
            }

            minL[0] = Integer.MAX_VALUE;
            maxL[0] = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++){
                minL[i + 1] = Math.min(minL[i], nums[i]);
                maxL[i + 1] = Math.max(maxL[i], nums[i]);
            }

            minR[N] = minL[0];
            maxR[N] = maxR[0];

            for (int i = N - 1; i >= 0; i--){
                minR[i] = Math.min(minR[i + 1], nums[i]);
                maxR[i] = Math.max(maxR[i + 1], nums[i]);
            }


            while(Q-- > 0){
                int L = in.nextInt() - 1, R = in.nextInt() - 1;
                long sum = total - (A[R + 1] - A[L]);
                int c = N - (R - L + 1);
                int min = Math.min(minL[L], minR[R + 1]);
                int max = Math.max(maxL[L], maxR[R + 1]);
                long ans = (long)((1.0 * (sum -  c * min + c) * 1_000_000) / (max - min + 1));
                System.out.println(ans);
            }

        }
    }
}