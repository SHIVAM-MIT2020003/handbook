package cses.graph_algorithm;

import java.io.*;
import java.util.*;


/*
    Find cycle
 */
public class RoundTrip {

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
        solve();
    }

    static void solve(){
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


        boolean isCycleFound  = false;
        boolean[] iv = new boolean[n + 1];
        Stack<Integer> path = new Stack<>();
        for (int u = 1; u <= n && !isCycleFound; u++){
            if(!iv[u] && dfs(graph, u, iv, path, -1)){
                isCycleFound = true;
                StringBuilder ans = new StringBuilder("");
                int length = 2;

                int peek = path.pop();
                ans.append(peek + " ");

                while(!path.isEmpty() && path.peek() != peek){
                    ans.append(path.pop() + " ");
                    length++;
                }

                ans.append(path.pop());

                out.println(length);
                out.println(ans.toString());
            }
        }

        if(!isCycleFound){
            out.println("IMPOSSIBLE");
        }
        out.flush();
    }

    static boolean dfs(ArrayList<Integer>[] graph, int u, boolean[] iv, Stack<Integer> path, int p){
        path.push(u);
        iv[u] = true;

        for (int v : graph[u]){
            if(!iv[v]){
                if(dfs(graph, v, iv, path, u)) return true;
            }else{
                if(v != p){
                    path.push(v);
                    return true;
                }
            }
        }

        path.pop();
        return false;
    }
}
