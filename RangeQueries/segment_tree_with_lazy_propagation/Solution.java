package RangeQueries.segment_tree_with_lazy_propagation;

import java.io.PrintWriter;
import java.util.Scanner;

//For range queries and range updates
public class Solution {
    static int powerOf2(int n){
        int p = (int)Math.ceil(Math.log(n) / Math.log(2));
        return (int)Math.pow(2, p);
    }

    static long[] tree;
    static long[] cache;
    static boolean[] isLazy;
    static int N;

    //Segment tree for sum queries
    static void builtSumST(int[] nums){
        int n = nums.length;
        N = powerOf2(n);
        tree = new long[2 * N];
        cache = new long[2 * N];
        isLazy = new boolean[2 * N];

        //leaf node filling
        for (int i = 0; i < n; i++){
            tree[n + i] = nums[i];
        }

        //internal node filling
        for (int i = n - 1; i >= 1; i--){
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    static void apply(int root, int left, int right, long val){
        tree[root] += val * (right - left + 1);
        if(left != right) {
            isLazy[root] = true;
            cache[root] += val;
        }
    }

    static void pushDown(int root, int left, int right){
        if(isLazy[root]){
            isLazy[root] = false;
            int mid = (left + right) / 2;
            apply(2 * root, left, mid, cache[root]);
            apply(2 * root + 1, mid + 1, right, cache[root]);
            cache[root] = 0;
        }
    }

    //Ques: Why we dont have to do apply in getSum method??
    //Ans: Because, it is already applied in pushDown call.
    static long getSum(int root, int low, int high, int qlow, int qhigh){
        //complete overlap
        if(qlow <= low && high <= qhigh) return tree[root];

        //disjoint
        if(qlow > high || qhigh < low) return 0;

        //partial overlap
        pushDown(root, low, high);
        int mid = (low + high) / 2;
        return getSum(root * 2, low, mid, qlow, qhigh) + getSum(root * 2 + 1, mid + 1, high, qlow, qhigh);
    }

    public static void update(int root, int left, int right, int qleft, int qright, int val){
        //complete overlap
        if(qleft <= left && right <= qright){
            //apply new changes
            apply(root, left, right, val);
            return;
        }

        //disjoint
        if(right < qleft || left > qright) return;

        //partial overlap
        pushDown(root, left, right);
        int mid = (left + right) / 2;
        update(2 * root, left, mid, qleft, qright, val);
        update(2 * root + 1, mid + 1, right, qleft, qright, val);
        tree[root] = tree[2 * root] + tree[2 * root + 1];
    }

//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
//
//        int[] nums = {1,2,3,4,5,6,7,8};
//        builtSumST(nums);
//        update(1, 0, N - 1, 0, 2, 2);
//        System.out.println(getSum(1, 0, N - 1, 0,0));
//
//    }
}
