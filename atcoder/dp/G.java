package atcoder.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int E = in.nextInt();
        Node[] g = new Node[N + 1];
        for (int i = 1; i <= N; i++)
        {
            g[i] = new Node();
        }

        for (int i = 0; i < E; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].adj.add(v);
        }

        Integer[] distance = new Integer[N + 1];
        boolean[] iv = new boolean[N + 1];
        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(!iv[i])
                ans = Math.max(ans, dfs(g, i, distance, iv));
        }
        System.out.println(ans);
    }

    public static int dfs(Node[] g, int u, Integer[] distance, boolean[] isVisited){
        if(distance[u] != null) return distance[u];
        isVisited[u] = true;
        distance[u] = 0;
        for (int v : g[u].adj){
            if(isVisited[v]){
                distance[u] = Math.max(distance[u], distance[v] + 1);
            }else{
                distance[u] = Math.max(distance[u], dfs(g, v, distance, isVisited) + 1);
            }
        }
        return distance[u];
    }
}

class Node{
    List<Integer> adj = new ArrayList<>();
}
