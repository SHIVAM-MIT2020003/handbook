package cses.graph_algorithm;

import java.io.*;
import java.util.*;

/*
find components
 */

public class BuildingRoads {

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
        int n = in.nextInt();
        int e = in.nextInt();

        int[] leaders = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 1; i <= n; i++){
            leaders[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < e; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            union(u, v, leaders, size);
        }

        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if(leaders[i] == i){
                l.add(i);
            }
        }

        out.println(l.size() - 1);

        for (int i = 1; i < l.size(); i++){
            out.println(l.get(0) + " " + l.get(i));
        }
        out.flush();
    }

    static int find(int u, int[] leaders){
        while(u != leaders[u]){
            u = leaders[u];
        }
        return u;
    }


    static void union(int u, int v, int[] leaders, int[] size){
        int pu = find(u, leaders);
        int pv = find(v, leaders);

        if(pu == pv) return;

        if(size[pu] <= size[pv]){
            leaders[pu] = pv;
            size[pv] += size[pu];
        }else{
            leaders[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
