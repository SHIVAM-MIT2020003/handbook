package cses.graph_algorithm;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


/*
Dijkstra algorithm on directed graph
 */
public class ShortestRoutes1 {

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

    static class Node{
        int id;
        long w;
        public Node(int id, long w){
            this.id = id;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        boolean isAllSame = true;
        for (int i = 0; i < m; i++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int w = in.nextInt();
            if(w != 1){
                isAllSame = false;
            }
            graph[u].add(new int[]{v, w});
        }

        long[] distance;
        if(isAllSame){
            distance = bfs(graph, 0, n);
        }else{
            distance = dijkstras(graph, 0, n);
        }

        for (int i = 0; i < n; i++){
            out.print(distance[i] + " ");
        }
        out.flush();
        out.close();
    }

    public static long[] bfs(ArrayList<int[]>[] graph, int u, int n){
        long[] distance = new long[n];
        distance[u] = 0;

        boolean[] iv = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        iv[u] = true;

        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int cur = queue.remove();
                distance[cur] = level;
                for (int[] t : graph[cur]){
                    int v = t[0];
                    if(!iv[v]){
                        iv[v] = true;
                        queue.offer(v);
                    }
                }
                distance[cur] = level;
            }
            level++;
        }
        return distance;
    }

    public static long[] dijkstras(ArrayList<int[]>[] graph, int u, int n){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] distance = new long[n];
        boolean[] isCovered = new boolean[n];

        pq.offer(new long[]{u, 0});
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[u] = 0l;

        while(!pq.isEmpty()){
            int cur = (int)pq.peek()[0];
            pq.poll();
            if(isCovered[cur]){
               continue;
            }

            isCovered[cur] = true;

            for (int[] adj : graph[cur]){
                int v = adj[0];
                long w = adj[1];
                if(!isCovered[v] && distance[v] > distance[cur] + w){
                    distance[v] = distance[cur] + w;
                    pq.offer(new long[]{v, distance[v]});
                }
            }
        }

        return distance;
    }
}
