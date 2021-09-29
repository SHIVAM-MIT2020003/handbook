package cses.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberSpiral {
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
            long x = in.nextLong();
            long y = in.nextLong();

            long d = Math.max(x, y) - 1;


            long ans = 0l;
            long e = d * 2 + 1;
            if((d + 1) % 2  == 0){
                if(x >= y){
                    ans = d * d + (e - y + 1);
                }else{
                    ans = d * d + x;
                }
            }else{
                if(x >= y){
                    ans = d * d + y;
                }else{
                    ans = d * d + (e - x + 1);
                }
            }
            out.println(ans);
            out.flush();
        }
    }

}

/*

id = ?

id is even

e = id + id - 1;
if(row >= col)
    ans = id * id + (e - col + 1)
else
    ans = id * id + row


id is odd
if(row >= col){
    ans = id * id + col
else
    ans = id * id + (e - row  + 1)




 */

