package graph.disjointset;

public class Solution {

    static int N;
    static int[] leader = new int[N];
    static int[] size = new int[N];

    public static int find(int x){
        //check whether x is global leader or not
        while(leader[x] != x)
            x = leader[x];
        return x;
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(size[a] <= size[b]){
            size[b] += size[a];
            leader[a] = b;
        }else{
            size[a] += size[b];
            leader[b] = a;
        }
    }
}


