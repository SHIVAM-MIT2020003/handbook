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
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
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
        int C = 0, D = 0;
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!iv[u]){
//                count++; //count number of components
                int val = dfs2(GT, u, iv);
                if(val % 2 == 0){
                    D += val;
                }else{
                    C += val;
                }
            }
        }
        return C - D;
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

    public int dfs2(ArrayList<ArrayList<Integer>> G, int u, boolean[] iv){
        iv[u] = true;
        int count = 0;
        for (int v : G.get(u)){
            if(!iv[v]){
                count += dfs2(G, v, iv);
            }
        }
        return count + 1;
    }
}