package RangeQueries.SegmentTree;

import java.util.Arrays;

public class Solution {
    //during input create array of size N, but remaining time just assume it is "nInPowOf2"
    public static int[] constructSegmentTree(int[] nums, int N){
        int nInPowOf2 = get(N);
        int[] st = new int[nInPowOf2  * 2];

        for (int i = 0; i < nums.length; i++){
            update(i, nums[i], nInPowOf2, st);
        }
        return st;
    }

    //N must be power of 2
    public static void update(int i, int val, int N, int[] st){
        i += N;
        st[i] += val;
        for (i /=  2; i > 0; i /= 2){
            st[i] = st[i * 2] + st[i * 2 + 1];
        }
    }

    //N must  be  power of 2 ie. "nInPowOf2"
    public static int sum(int a, int b, int N, int[] st){
        a += N; b += N;
        int sum = 0;
        while(a <= b){
            if(a % 2 == 1)  sum += st[a++];
            if(b % 2 == 0) sum += st[b--];
            a /= 2; b /= 2;
        }
        return sum;
    }

    public static int get(int n){
        int x = (int)Math.ceil(Math.log(n) / Math.log(2));
        return (int)Math.pow(2, x);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] st = constructSegmentTree(nums, nums.length);
        Arrays.stream(st).forEach(e -> System.out.print(e + " "));
    }

}