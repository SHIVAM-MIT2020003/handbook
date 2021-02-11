package RangeQueries.FenwickTree;

public class Solution {
    //ft 1..N
    public static int[] contructFenwickTree(int[] arr){
        int[] ft = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            update(ft, arr[i], i);
        }
        return ft;
    }

    public static void update(int[] ft, int val, int i){
        i++;
        while(i < ft.length){
            ft[i] += val;
            i = i + (i & (-i));
        }
    }

    //[0,k] inclusive for ft it is [1, k + 1]
    public static int sum(int[] ft, int k){
        k++;
        int sum = 0;
        while(k > 0){
            sum += ft[k];
            k = k - (k & (-k));
        }
        return sum;
    }
}
