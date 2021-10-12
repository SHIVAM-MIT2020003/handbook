package codeforces.problems;

import java.io.*;
import java.util.*;

public class ZigZag {
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

    public static void main(String[] args) {
        int t = in.nextInt();
        while(t-- > 0){
            int  n = in.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            int[][] prefix = new int[n + 1][n + 1];
            int[][] suffix = new int[n + 1][n + 1];

            prefix[0][nums[0]]++;
            for (int i = 1; i < n; i++){
                for (int j = 0; j <= n; j++){
                    prefix[i][j] = prefix[i - 1][j];
                }

                prefix[i][nums[i]]++;
            }

            suffix[n - 1][nums[n - 1]]++;
            for (int i = n - 2; i >= 0; i--){
                for (int j = 0; j <= n; j++){
                    suffix[i][j] = suffix[i + 1][j];
                }

                suffix[i][nums[i]]++;
            }

            long count = 0l;

            for (int i = 1; i < n - 2; i++){
                for (int j = i + 1; j < n - 1; j++){
                    count += prefix[i - 1][nums[j]] * suffix[j + 1][nums[i]];
                }
            }

            out.println(count);
            out.flush();
        }
    }
}
























