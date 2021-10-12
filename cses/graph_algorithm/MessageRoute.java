package cses.graph_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


/*

    path with minimum number of nodes

 */
public class MessageRoute {
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

    public static void main(String[] args) {
        int n = in.nextInt();
        int e = in.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] parent = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        boolean[] iv = new boolean[n + 1];

        queue.offer(1);
        iv[1] = true;

        boolean isFound = false;
        while(!queue.isEmpty() && !isFound){
            int u = queue.remove();
            if(u == n){
                isFound = true;
                break;
            }else{
                for (int v : graph[u]){
                    if(!iv[v]){
                        iv[v] = true;
                        queue.offer(v);
                        parent[v] = u;
                    }
                }
            }
        }

        if(!isFound){
            out.println("IMPOSSIBLE");
        }else{
            List<Integer> path = new ArrayList<>();
            path.add(n);

            int u = n;
            while(u != 1){
                u = parent[u];
                path.add(u);
            }

            out.println(path.size());

            for (int i = path.size() - 1; i >= 0; i--){
                out.print(path.get(i) + " ");
            }
        }
        out.flush();
    }
}

/*
1 ----> n


1 2 3 4 5
        3


*/