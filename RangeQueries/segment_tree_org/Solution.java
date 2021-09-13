package RangeQueries.segment_tree_org;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    static int powerOf2(int n){
        int p = (int)Math.ceil(Math.log(n) / Math.log(2));
        return (int)Math.pow(2, p);
    }

    static long[] tree;
    //Segment tree for sum queries
    static void builtSumST(int[] nums){
        int n = nums.length;
        tree = new long[2 * n];
        //leaf node filling
        for (int i = 0; i < n; i++){
            tree[n + i] = nums[i];
        }

        //internal node filling
        for (int i = n - 1; i >= 1; i--){
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    static long getSum(int root, int low, int high, int qlow, int qhigh){
        //completely overlap
        if(qlow <= low && high <= qhigh) return tree[root];

        //disjoint
        if(qlow > high || qhigh < low) return 0;

        int mid = (low + high) / 2;

        return getSum(root * 2, low, mid, qlow, qhigh) + getSum(root * 2 + 1, mid + 1, high, qlow, qhigh);
    }

    static void update(int i, int val, int n){
        tree[n + i] = val;
        for (int j = (n + i) / 2; j >= 1; j = j/2){
            tree[j] = tree[2 * j] + tree[2 * j + 1];
        }
    }

    public void change(int root, int left, int right, int qleft, int qright, int val){
        //recursive update
        if(qleft <= left && right <= qright){
            // I am leaf
            tree[root] = val;
            return;
        }

        if(right < qleft || left > qright) return;

        int mid = (left + right) / 2;
        change(2 * root, left, mid, qleft, qright, val);
        change(2 * root + 1, mid + 1, right, qleft, qright, val);
        tree[root] = tree[2 * root] + tree[2 * root + 1];
    }


    //Segment tree for min queries
    static void builtMinST(int[] nums){
        int n = nums.length;
        tree = new long[2 * n];
        //leaf node filling
        for (int i = 0; i < n; i++){
            tree[n + i] = nums[i];
        }

        //internal node filling
        for (int i = n - 1; i >= 1; i--){
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }

    static long getMin(int root, int low, int high, int qlow, int qhigh){
        //completely overlap
        if(qlow <= low && high <= qhigh) return tree[root];

        //disjoint
        if(qlow > high || qhigh < low) return Integer.MAX_VALUE;

        int mid = (low + high) / 2;
        return Math.min(getMin(root * 2, low, mid, qlow, qhigh), getMin(root * 2 + 1, mid + 1, high, qlow, qhigh));
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

    public static void main(String[] args) {
        IScanner in = new IScanner();
        int n = in.nextInt(), q = in.nextInt();
        int N = powerOf2(n);
        int[] arr = new int[N];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        builtMinST(arr);

        for (int i = 0; i < q; i++){
            int l = in.nextInt() - 1;
            int h = in.nextInt() - 1;
            PrintWriter out = new PrintWriter(System.out);
            out.println(getMin(1, 0, N - 1, l, h));
            out.flush();
        }
    }
}