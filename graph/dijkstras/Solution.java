package graph.dijkstras;


import java.util.*;
import java.io.*;


class Solution {
    int MOD = (int)(1e9 + 7);
    public static void main(String[] args) {
        IScanner in = new IScanner();
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int e = in.nextInt();
            int[][] g = new int[n + 1][n + 1];
            for (int i = 0; i < e; i++)
            {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();
                if(g[u][v] != 0){
                    if(g[u][v] > w){
                        g[u][v] = w;
                        g[v][u] = w;
                    }
                }else{
                    g[u][v] = w;
                    g[v][u] = w;
                }
            }

            int s = in.nextInt();

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] distance = new int[n + 1];
            boolean[] isCovered = new boolean[n + 1];

            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[s] = 0;
            pq.offer(new int[] {s, 0});

            while(!pq.isEmpty()){
                int u = pq.peek()[0], w = pq.peek()[1];
                pq.poll();
                if(isCovered[u]) continue;
                isCovered[u] = true;
                for (int v = 1; v <= n; v++){
                    if(g[u][v] != 0){
                        if(distance[u] + g[u][v] < distance[v]){
                            distance[v] = distance[u] + g[u][v];
                            pq.offer(new  int[]{v, distance[v]});
                        }
                    }
                }
            }

            for (int i = 1; i <= n; i++){
                if(i != s){
                    System.out.print((distance[i] == Integer.MAX_VALUE ? -1 : distance[i]) + " ");
                }
            }
            System.out.println();
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int x = 2; x*x <= n; x++) {
            if (n%x == 0) return false;
        }
        return true;
    }

    static boolean[] sieveOfEratosthenes(int n){
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans, true);
        ans[1] = false;
        for (int i = 2; i <= n; i++){
            if(ans[i]){
                for (int j = 2 * i; j <= n; j += i){
                    ans[j] = false;
                }
            }
        }
        return ans;
    }

    long modPow(int x, int n, int m) {
        if (n == 0) return 1 % m;
        long u = modPow(x,n / 2, m);
        u = (u * u) % m;
        if (n % 2 == 1) u = (u * x) % m;
        return u;
    }

    static class IScanner {
        BufferedReader br;
        StringTokenizer st;
        public IScanner()
        {
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

        String nextLine(){
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
