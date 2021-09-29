package cses.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        IScanner in = new IScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();

        if(n == 1){
            System.out.println("1");
        }else if(n <= 3){
            System.out.println("NOT SOLUTION");
        }else{
            if(n % 2 == 0){
                for (int i = 2; i <= n; i += 2){
                    System.out.print(i + " ");
                }

                for (int i =  1; i <= n; i += 2){
                    System.out.print(i + " ");
                }
            }else{
                for (int i =  1; i <= n; i += 2){
                    System.out.print(i + " ");
                }

                for (int i = 2; i <= n; i += 2){
                    System.out.print(i + " ");
                }
            }
        }
    }

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
}
/*

n = 1
1


n = 2

1 2
NOT POSSIBLE

n =  3

1 2 3
1 3 2
2 1 3
2 3 1
3 2 1
3 1 2

NOT POSSIBLE


Even

even odd


n = 4

1 2 3 4

odd = 1 3
even =  2 4

2 4 1 3


2 4 1 3


n = 6

1 3 5 2 4 6

n = 8

1 3 5 7 2 4 6 8

odd

odd even

n = 5


odd : 1 3 5
even : 2 4

1 3 5 2 4


 */
