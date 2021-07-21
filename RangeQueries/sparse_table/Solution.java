package RangeQueries.sparse_table;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static class FastScanner{
        BufferedReader bf;
        StringTokenizer st;

        public FastScanner(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(bf.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine(){
            String str = "";
            try{
                str = bf.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }

    static int[][] st;
    static int LOG, N;

    public static void init(int[] nums){
        LOG = (int)(Math.log(N) / Math.log(2)) + 1;

        st = new int[N][LOG];
        for (int i = 0; i < N; i++){
            st[i][0] = nums[i];
        }

        for (int j = 1; j < LOG; j++){
            for (int i = 0;  i + (1 << (j - 1)) < N; i++){
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public static int query(int L, int R){
        int len = R - L + 1;
        int k = (int)(Math.log(len) / Math.log(2));
        return Math.min(st[L][k], st[R - (1 << k) + 1][k]);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++){
            nums[i] = in.nextInt();
        }

        init(nums);

        int q = in.nextInt();
        while(q-- > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(query(l, r));
        }
    }
}

// min, max, gcd, AND

// requires idempotent property
// A op A = A

//No updation allowed
//O(nlogn) => creation time
//O(1) => query time
