package graph.prims;


import java.util.*;
import java.io.*;

public class Solution{
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

    public static void main(String[] args){
        IScanner in = new IScanner();
        int N = in.nextInt();
        int E = in.nextInt();

        ArrayList<int[]> []graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < E; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int s = in.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] isVisited = new boolean[N + 1];
        int ans = 0;

        pq.add(new int[]{s, 0});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0], w = node[1];
            if(isVisited[u]){
                continue;
            }
            isVisited[u] = true;
            ans += w;
            for (int[] v : graph[u]){
                if(!isVisited[v[0]]){
                    pq.offer(v);
                }
            }
        }
        System.out.println(ans);
    }
}
