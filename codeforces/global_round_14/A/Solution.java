package codeforces.global_round_14.A;

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

    public static void main(String[] args) {
        IScanner in = new IScanner();
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int x = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);
            int total = 0;
            int i;
            for (i = 0; i < n; i++){
                total += arr[i];
                if(total == x)
                {
                  break;
                }
            }

            if(i == n - 1){
                System.out.print("NO");
            }else if(i == n){
                System.out.println("YES");
                for (int j = 0; j < n; j++){
                    System.out.print(arr[j] + " ");
                }
            }else{
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                System.out.println("YES");
                for (int j = 0; j < n; j++){
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("");
        }
    }
}

