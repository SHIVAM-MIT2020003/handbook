package RangeQueries.tree_euler_tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class Node{
        List<Integer> adj = new ArrayList<>();
    }
    static class Time{
        int in, out;
        public Time(){
            in = -1;
            out = -1;
        }
    }

    static int[] nodeValues;
    static int n;
    static Node[] tree;
    static List<Integer> flatTree;
    static Time[] inOutTime;
    static long[] st;
    static int stN;

    public static void main(String[] args){
        IScanner in = new IScanner();
        n = in.nextInt();
        int q = in.nextInt();
        nodeValues = new int[n];
        for  (int i =  0; i < n; i++){
            nodeValues[i] = in.nextInt();
        }

        tree = new Node[n];
        for (int i = 0; i < n; i++) tree[i] = new Node();

        for (int i = 0; i <  n - 1; i++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;

            tree[u].adj.add(v);
            tree[v].adj.add(u);
        }

        solve();

        while(q-- > 0){
            int type = in.nextInt();
            if(type == 1){
                int node = in.nextInt() - 1;
                int x = in.nextInt();
                nodeValues[node] = x;
                int start = inOutTime[node].in;
                int end = inOutTime[node].out;
                update(1, 0, stN - 1, start, start, x);
                update(1, 0, stN - 1, end, end, x);
            }else{
                int node = in.nextInt() - 1;
                int start = inOutTime[node].in;
                int end = inOutTime[node].out;
                System.out.println(getSum(1, 0, stN - 1, start, end) / 2);
            }
        }
    }

    public static void solve(){
        flatTree = new ArrayList<>();
        dfs(0, -1);
        inOutTime = new Time[n];
        for (int i = 0; i  < n; i++){
            inOutTime[i] = new Time();
        }

        for (int i = 0; i < flatTree.size(); i++){
            if(inOutTime[flatTree.get(i)].in == -1){
                inOutTime[flatTree.get(i)].in = i;
            }
        }

        for (int i = flatTree.size() - 1; i >= 0; i--){
            if(inOutTime[flatTree.get(i)].out == -1){
                inOutTime[flatTree.get(i)].out = i;
            }
        }
        buildSegmentTree();
    }

    public static int power(int n){
        int p = (int)Math.ceil(Math.log(n) / Math.log(2));
        return (int)Math.pow(2, p);
    }

    public static void buildSegmentTree(){
        stN = power(flatTree.size());
        st = new long[2 * stN];
        for (int i = 0; i < flatTree.size(); i++){
            st[stN + i] = nodeValues[flatTree.get(i)];
        }

        for (int i = stN - 1; i >= 1; i--){
            st[i] = (long)st[i * 2] + st[i * 2 + 1];
        }
    }

    public static long getSum(int root, int left, int right, int qleft, int qright){
        if(left >= qleft && right <= qright){
            return st[root];
        }

        if(right < qleft || left > qright) return 0l;

        int mid = (left + right) / 2;
        return getSum(root * 2, left, mid, qleft, qright) + getSum(root * 2 + 1, mid + 1, right, qleft, qright);
    }

    public static void update(int root, int left, int right, int qleft, int qright, int value){
        if(left >= qleft && right <= qright){
            st[root] = value;
            return;
        }

        if(right < qleft || left > qright) return;

        int mid = (left + right) / 2;
        update(root * 2, left, mid, qleft, qright, value);
        update(root * 2 + 1, mid + 1, right, qleft, qright, value);
        st[root] = st[root * 2] + st[root * 2 + 1];
    }

    public static void dfs(int root, int parent){
        flatTree.add(root);
        for (int v : tree[root].adj){
            if(v != parent){
                dfs(v, root);
            }
        }
        flatTree.add(root);
    }

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
}

//
//input
//dfs
//flatting
//in and out time
//update 2 update
//sum