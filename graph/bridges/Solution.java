package graph.bridges;

import java.util.*;

public class Solution {
    public void dfs(List<Integer>[] graph, int u, int t, Integer[] p, int[] low, int[] dis, boolean[] isVisited, List<List<Integer>> ans){
        t++;
        isVisited[u] = true;
        low[u] = t;
        dis[u] = t;
        for (int v : graph[u]){
            if(!isVisited[v]){
                p[v] = u;
                dfs(graph, v, t, p, low, dis, isVisited, ans);
                low[u] = Math.min(low[u], low[v]);
                //check back-edge
                if(low[v] > dis[u]){
                    ans.add(Arrays.asList(u, v));
                }
                //v is part of circle
            }else if(p[u] == null || p[u] != v){
                low[u] = Math.min(low[u], low[v]);
            }
        }

    }
}

