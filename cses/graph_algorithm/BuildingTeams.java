package cses.graph_algorithm;

import java.io.*;
import java.util.*;

/*
    Bipartite
 */
public class BuildingTeams {
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
        solveUsingDFS();

    }

    static void solveUsingBFS(){
        int n = in.nextInt();
        int f = in.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < f; i++){
            int f1 = in.nextInt();
            int f2 = in.nextInt();
            graph[f1].add(f2);
            graph[f2].add(f1);
        }

        int[] color = new int[n + 1];
        boolean isColoringPossible = true;
        int c = 1;
        StringBuilder ans = new StringBuilder("");
        for (int u = 1; u <= n && isColoringPossible; u++){
            if(color[u] == 0){
                ans.append(1 + " ");
                if(!bfs(graph, u, color)) {
                    isColoringPossible = false;
                }
            }else{
                ans.append(color[u] + " ");
            }
        }


        if(!isColoringPossible){
            out.println("IMPOSSIBLE");
        }else{
            out.print(ans.toString());
        }

        out.flush();
    }

    static boolean bfs(ArrayList<Integer>[] graph, int u, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        color[u] = 1;
        int c = 2;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int cur = queue.remove();
                for (int v : graph[cur]){
                    if(color[v] == 0){
                        queue.offer(v);
                        color[v] = c;
                    }else{
                        if(color[v] == color[cur]){
                            return false;
                        }
                    }
                }
            }
            c = c == 1 ? 2 : 1;
        }
        return true;
    }

    static void solveUsingDFS(){
        int n = in.nextInt();
        int f = in.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < f; i++){
            int f1 = in.nextInt();
            int f2 = in.nextInt();
            graph[f1].add(f2);
            graph[f2].add(f1);
        }

        int[] color = new int[n + 1];
        boolean isColoringPossible = true;
        StringBuilder ans = new StringBuilder("");
        for (int u = 1; u <= n && isColoringPossible; u++){
            if(color[u] == 0){
                ans.append(1 + " ");
                if(!dfs(graph, u, color, 1)){
                    isColoringPossible = false;
                }
            }else{
                ans.append(color[u] + " ");
            }
        }

        if(!isColoringPossible){
            out.println("IMPOSSIBLE");
        }else{
            out.print(ans.toString());
        }

        out.flush();
    }

    static boolean dfs(ArrayList<Integer>[] graph, int u, int[] color, int c){
        color[u] = c;
        c = c == 1 ? 2 : 1;
        for (int v : graph[u]){
            if(color[v] == 0){
                if(!dfs(graph, v, color, c)) return false;
            }else{
                if(color[u] == color[v]) return false;
            }
        }
        return true;
    }
}

/*
color = 0 -> not visited
color = 1 -> grp - 1
color = 2 -> grp - 2
 */