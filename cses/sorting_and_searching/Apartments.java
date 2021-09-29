package cses.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {
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
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        long[] req = new long[n];
        long[] apt = new long[m];
        for (int i = 0; i < n; i++){
            req[i] = in.nextLong();
        }

        for (int i = 0; i < m; i++){
            apt[i] = in.nextLong();
        }

        Arrays.sort(apt);

        long count = 0;

        for (int i = 0; i < n; i++){
            int left = 0, right = m - 1;
            long ans = -1;
            long target = req[i] - k;

            while(left <= right){
                int mid = left + (right - left) / 2;
                if(apt[mid] >= target){
                    ans = apt[mid];
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

            if(ans == -1){
                continue;
            }else if(ans <= req[i] + k){
                count++;
            }
        }

        System.out.println(count);
    }
}
