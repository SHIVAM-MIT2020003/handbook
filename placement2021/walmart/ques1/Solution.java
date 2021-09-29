package placement2021.walmart.ques1;

//There are N cities in a country and M roads are connected these cities. The i-th road connects u and v cities bidirectionally.

// Initially, yoy can travel between any two cities using one/more roads. The roads will damage due to aging after some time.

//        Let inconvinience be the number of pairs of roads ( u<v) such that we are no longer able to travel between u and v using remaining roads.

//        For each i (1 <= i <= N), find the inconvinience just after the i-th road damages. Inconvinience is initially 0.

//        Example:

//        4 5
//        1 2
//        3 4
//        1 3
//        2 3
//        1 4

//        output: 0 0 4 5 6
//
//        Explanation: When first three roads are damaged, inconvinience is 4 since we can't travel between (1,2), (1,3), (2,4), and (3,4).

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] leaders = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 1; i <= n; i++){
            leaders[i] = i;
            size[i] = 1;
        }

        int[][] edges = new int[m][];

        for (int i = 0; i < m; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            edges[i] = new int[]{u, v};
        }

        long[] ans = new long[m];

        long totalPairs = n * (n - 1) / 2;

        for (int i = m - 1; i >= 0; i--){
            ans[i] = totalPairs;
            int u = edges[i][0];
            int v = edges[i][1];

            int pu = find(u, leaders);
            int pv = find(v, leaders);

            if(pu == pv){
                continue;
            }else{
                int sizePU = size[pu];
                int sizePV = size[pv];
                totalPairs -= sizePU * sizePV;
                union(u, v, leaders, size);
            }
        }

        for (int i = 0; i < m; i++){
            System.out.print(ans[i] + " ");
        }
    }

    public static int find(int u, int[] leaders){
        while(u != leaders[u]){
            u = leaders[u];
        }
        return u;
    }

    public static void union(int u, int v, int[] leaders, int[] size){
        u = find(u, leaders);
        v = find(v, leaders);
        if(u == v) return;

        if(size[u] <= size[v]){
            leaders[u] = v;
            size[v] += size[u];
        }else{
            leaders[v] = u;
            size[u] += size[v];
        }
    }
}
