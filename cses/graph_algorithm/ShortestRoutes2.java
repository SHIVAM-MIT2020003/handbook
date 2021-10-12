package cses.graph_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
Dijkstra algorithm on undirected graph
 */

public class ShortestRoutes2 {
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
    static final long INF = 0x3f3f3f3f3f3f3f3fL;

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        long[][] A = new long[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                A[i][j] = INF;
            }
            A[i][i] = 0l;
        }

        for (int i = 0; i < m; i++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int w = in.nextInt();

            if(A[u][v] > w){
                A[u][v] = w;
                A[v][u] = w;
            }
        }

        for (int k = 0; k < n; k++){
            for (int u = 0; u < n; u++){
                for (int v = 0; v < n; v++){
                    if(A[u][v] > A[u][k] + A[k][v]){
                        A[u][v] = A[u][k] + A[k][v];
                    }
                }
            }
        }

        for (int i = 1; i <= q; i++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            out.println(A[u][v] == INF ? -1 : A[u][v]);
        }

        out.flush();
        out.close();
    }
}

/*

intermediate vertex is 'k'
cost[u][v] = min(cost[u][v], cost[u][k] + cost[k][v])

 */
