package cses.sorting_and_searching;

import cses.Test;


import java.io.*;
import java.util.*;


public class DistinctNumber {
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
    static  IScanner in = new IScanner();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            set.add(in.nextInt());
        }

        System.out.println(set.size());
    }

}
