package graph.roads_and_lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        int q = in.nextInt();
        while(q-- > 0){
            int n = in.nextInt();
            int m = in.nextInt();
            int lib = in.nextInt();
            int road = in.nextInt();

            ArrayList<ArrayList<Integer>> G = new ArrayList<>();
            for (int i = 0; i <= n; i++){
                G.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++){
                int u = in.nextInt();
                int v = in.nextInt();
                G.get(u).add(v);
                G.get(v).add(u);
            }

            if(lib <= road){
                System.out.println(1l * n * lib);
                continue;
            }

            int[] p = new int[n + 1];
            int[] size = new int[n + 1];
            for (int i = 0; i <= n; i++){
                p[i] = i;
                size[i] = 1;
            }

            for (int u = 1; u <= n; u++){
                for (int v : G.get(u)){
                    union(u, v, p, size);
                }
            }

            long cost = 0l;
            for (int i = 1; i <= n; i++){
                if(p[i] == i){
                    cost += lib + (size[i] - 1) * road;
                }
            }
            System.out.println(cost);
        }
    }

    public static int find(int x, int[] leader) {
        while (leader[x] != x) x = leader[x];
        return x;
    }

    public static void union(int a, int b, int[] leader, int[] size) {
        a = find(a, leader);
        b = find(b, leader);
        if(a == b) return;
        if (size[a] <= size[b]) {
            size[b] += size[a];
            leader[a] = b;
        } else {
            size[a] += size[b];
            leader[b] = a;
        }
    }
}