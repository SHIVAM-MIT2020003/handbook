package graph.SCC;

import java.util.*;

class Solution
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        ArrayList<ArrayList<Integer>> GT = new ArrayList<>();
        for (int i = 0; i  < V; i++){
            GT.add(new ArrayList<>());
        }
        int E = in.nextInt();
        for (int i = 0; i < E; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            GT.get(u).add(v);
        }

        System.out.println(new Solution().kosaraju(V, GT));
    }


    public int kosaraju(int V, ArrayList<ArrayList<Integer>> G) {
        ArrayList<ArrayList<Integer>> GT = new ArrayList<>();
        for (int i = 0; i  < V; i++){
            GT.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++){
            for (int v : G.get(u)){
                GT.get(v).add(u);
            }
        }

        int count = 0;
        boolean[] iv = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        dfs1(G, 0, iv, stack);

        Arrays.fill(iv, false);
        for (int i = 0; i < V; i++){
            int u = stack.pop();
            if(!iv[u]){
                count++;
                dfs2(GT, u, iv);
            }
        }
        return count;
    }

    public void dfs1(ArrayList<ArrayList<Integer>> G, int u, boolean[] iv, Stack<Integer> stack){
        iv[u] = true;
        for (int v : G.get(u)){
            if(!iv[v]){
                dfs1(G, v, iv, stack);
            }
        }
        stack.push(u);
    }

    public void dfs2(ArrayList<ArrayList<Integer>> G, int u, boolean[] iv){
        iv[u] = true;
        for (int v : G.get(u)){
            if(!iv[v]){
                dfs2(G, v, iv);
            }
        }
    }
}