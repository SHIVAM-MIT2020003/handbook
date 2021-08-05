package graph.articulation_points;

public class Solution {
    public void dfs(int[][] graph, int u, int[] disc, int[] low, Integer[] par, boolean[] isVisited, int time, boolean[] AP){
        isVisited[u] = true;
        disc[u] = time + 1;
        low[u] = time + 1;
        int c = 0;
        //statement 1: this loop is for only children of 'u'
        for (int v = 0; v < graph[u].length; v++){
            if(graph[u][v] == 1){
                if(!isVisited[v]){
                  c++;
                  par[v] = u;
                  dfs(graph, v, disc, low, par, isVisited, time + 1, AP);
                  low[u] = Math.min(low[u], low[v]);
                  if(par[u] == null && c > 1){
                      AP[u] = true;
                  }
                  if(par[u] != null && low[v] >= disc[u]){
                      AP[u] = true;
                  }
                }else if(par[u] == null || par[u] != v){ //make sure, 'v' should not be the parent of 'u'... inorder  to satisfy statement 1
                    low[u] = Math.min(low[u], low[v]);
                }
            }
        }
    }
}
