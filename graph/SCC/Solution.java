package graph.SCC;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            int u = in.nextInt();
            int v = in.nextInt();

            graph[u].add(v);
        }

        System.out.println(kosaraju(n, k, graph));


    }

    public static int kosaraju(int n, int k, ArrayList<Integer>[] G) {
        ArrayList<Integer>[] GT = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++){
            GT[i] = new ArrayList<>();
        }

        for (int u = 1; u <= n; u++){
            for (int v : G[u]){
                GT[v].add(u);
            }
        }

        int count = 0;
        boolean[] iv = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        for (int u = 1; u <= n; u++)
            if(!iv[u])
                dfs1(G, u, iv, stack);

        Arrays.fill(iv, false);

        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!iv[u]){
                count++;
                dfs2(GT, u, iv);
            }
        }
        return count - 1;
    }

    public static void dfs1(ArrayList<Integer>[] G, int u, boolean[] iv, Stack<Integer> stack){
        iv[u] = true;
        for (int v : G[u]){
            if(!iv[v]){
                dfs1(G, v, iv, stack);
            }
        }
        stack.push(u);
    }

    public static void dfs2(ArrayList<Integer>[] G, int u, boolean[] iv){
        iv[u] = true;
        for (int v : G[u]){
            if(!iv[v]){
                dfs2(G, v, iv);
            }
        }
    }
}
