package tree.binary_lifting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Solution {
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
    static class Node{
        List<Integer> children = new ArrayList<>();
    }
    static int[][] up;
    static int LOG;
    static int[] depth;

    public static void main(String[] args) {
        IScanner in = new IScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++){
            tree[i] = new Node();
        }

        for (int u = 0; u < n; u++){
            int m = in.nextInt();
            if(m == 0) continue;
            for (int v = 0; v < m; v++){
                tree[u].children.add(in.nextInt());
            }
        }

        int q = in.nextInt();

        LOG = (int)(Math.log(n) / Math.log(2)) + 1;
        up = new int[n][LOG];
        depth = new int[n];

        dfs(tree, 0);

        while(q-- > 0){
            int u = in.nextInt();
            int v = in.nextInt();
            out.println(getLCA(u, v));
            out.flush();
        }
    }

    public static void dfs(Node[] tree, int u){
        for (int v : tree[u].children){
            depth[v] = depth[u] + 1;
            up[v][0] = u;
            for (int i = 1; i < LOG; i++){
                int p = up[v][i - 1];
                up[v][i] = up[p][i - 1];
            }
            dfs(tree, v);
        }
    }

    public static int getLCA(int u, int v){
        if(depth[u] > depth[v]){
            int temp = v;
            v = u;
            u = temp;
        }

        int k = depth[v] - depth[u];
        for (int i = LOG - 1; i >= 0; i--){
            if((k & (1 << i)) > 0){
                v = up[v][i];
            }
        }

        if(u == v) return u;

        for (int i = LOG - 1; i >= 0; i--){
            if(up[u][i] != up[v][i]){
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }
}



