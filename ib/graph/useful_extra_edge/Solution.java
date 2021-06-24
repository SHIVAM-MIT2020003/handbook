package ib.graph.useful_extra_edge;

import java.util.*;

public class Solution {
    static class pair{
        int to, weight;
        pair(int x, int y){
            to = x;
            weight = y;
        }
    }

    static ArrayList<ArrayList<pair>> gr = new ArrayList<>();

    private int shortestPath(int nodes, int start, int end, int[][] E){
        int[] distance = new int[nodes];
        int[] parent = new int[nodes];
        boolean[] isCovered = new boolean[nodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<pair> p = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.weight - o2.weight;
            }
        });
        p.add(new pair(start, 0));
        distance[start] = 0;

        while(!p.isEmpty()){
            int node = p.peek().to;
            int dis = p.peek().weight;
            p.poll();
            if (isCovered[node]) continue;
            isCovered[node] = true;
            for(pair child : gr.get(node)){
                int new_node = child.to;
                int new_distance = child.weight;

                if (!isCovered[new_node] && dis + new_distance <= distance[new_node]){
                    distance[new_node] = dis + new_distance;
                    p.add(new pair(new_node, distance[new_node]));
                    parent[new_node] = node;
                }
            }
        }
        
        
        if( parent[end] == -1) return -1;
        int total_sum = distance[end];
        
        int result = Integer.MAX_VALUE;
        for( int[] road : E){
            int temp = total_sum;
            int from = --road[0];
            int to = --road[1];
            int dist = road[2];
            if( from >= nodes || to >= nodes) continue;
            if(distance[from] == Integer.MAX_VALUE || distance[to] == Integer.MAX_VALUE) continue;
            int old_dist = Math.abs(distance[from] - distance[to]);
            if ( old_dist > dist){
                temp = temp - old_dist + dist;
            }
            result = Math.min(result, temp);
        }
        return result;
    }
    public int solve(int A, int[][] B, int C, int D, int[][] E) {
        gr.clear();
        C = --C;
        D = --D;
        for(int  i =0; i < A; i++) gr.add(new ArrayList<>());
        for(int[] edge : B){
            int from = edge[0]-1;
            int to = edge[1]-1;
            int weight = edge[2];
            gr.get(from).add(new pair(to, weight));
            gr.get(to).add(new pair(from, weight));
        }
        return shortestPath(A, C, D, E);
    }
}
