package cses.sorting_and_searching;

import java.io.*;
import java.util.*;

public class FerrisWheel {
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

    static Random rand = new Random();

    static void shuffle(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            int j = rand.nextInt(i + 1);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] nums = new int[n];
        long x = in.nextInt();
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        shuffle(nums, n);
        Arrays.sort(nums);
        int count = 0;
        int s = 0, e = n - 1;
        while(s <= e){
            if(nums[s] + nums[e] <= x){
                s++; e--;
            }else{
                e--;
            }
            count++;
        }
        out.println(count);
        out.flush();
    }
}
