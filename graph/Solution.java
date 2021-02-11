package graph;

import java.util.*;
import java.io.*;

class TestClass {
    static class IScanner {
        BufferedReader br;
        StringTokenizer st;
        public IScanner()
        {
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long inv = 0;
    public static void main(String args[] ) throws Exception {
        IScanner in = new IScanner();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        mergeSort(arr, 0, n - 1);
        System.out.println(inv);
    }
    static void mergeSort(int[] nums, int s, int e){
        if(s < e){
            int mid = s + ((e - s) / 2);
            mergeSort(nums, s, mid);
            mergeSort(nums, mid + 1, e);
            merge(nums, s, mid, e);
        }
    }

    static void merge(int[] nums, int s, int mid, int e){
        int n1 = (mid - s + 1);
        int n2 = (e - mid);
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
        {
            left[i] = nums[s + i];
        }

        for (int i = 0; i < n2; i++){
            right[i] = nums[mid + i + 1];
        }

        int l = 0, r = 0, k = s;

        while(l < n1 && r < n2)
        {
            if(left[l] <= right[r]){
                nums[k++] = left[l++];
            }else{
                inv += (n1 - l);
                nums[k++] = right[r++];
            }
        }

        while(l < n1){
            nums[k++] = left[l++];
        }

        while(r < n2){
            nums[k++] = right[r++];
        }
    }
}
