package RangeQueries.segment_tree_on_index;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] nums =  {2,3,3,1,2};
        A = nums;
        build(nums);
        Arrays.stream(tree).forEach(val -> System.out.print(val + " "));
        int i = getMin(1, 0, 7, 0, 4);
        System.out.println(i);
    }
    static int powerOf2(int n){
        int p = (int)Math.ceil(Math.log(n) / Math.log(2));
        return (int)Math.pow(2, p);
    }

    static int[] tree;
    static int N;
    static int[] A;
    //Segment tree for sum queries

    static void build(int[] nums){
        int n = nums.length;
        N = powerOf2(n);
        tree = new int[2 * N];
        //leaf node filling
        for (int i = 0; i < N; i++){
            if(i < n)
                tree[N + i] = i;
            else
                tree[N + i] = -1;
        }

        //internal node filling
        for (int i = N - 1; i >= 1; i--){
            int c1 = tree[2 * i];
            int c2 = tree[2 * i + 1];
            if(c1 == -1){
                tree[i] = c2;
            }else if(c2 == -1){
                tree[i] = c1;
            }else if(A[c1] <= A[c2]){
                tree[i] = c1;
            }else{
                tree[i] = c2;
            }
        }
    }

    static int getMin(int root, int low, int high, int qlow, int qhigh){
        //completely overlap
        if(qlow <= low && high <= qhigh) return tree[root];

        //disjoint
        if(qlow > high || qhigh < low) return -1;

        int mid = (low + high) / 2;
        int l1 = getMin(root * 2, low, mid, qlow, qhigh);
        int l2 = getMin(root * 2 + 1, mid + 1, high, qlow, qhigh);
        if(l1 == -1) return l2;
        if(l2 == -1) return l1;
        if(A[l1] <= A[l2]){
            return l1;
        }else{
            return l2;
        }
    }
}
