package placement2021.walmart.ques4;


import java.util.*;
import java.io.*;

public class Solution {
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
        try {
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void solve(){
        int t = in.nextInt();
        while(t-- > 0){
            char[] days = in.nextLine().toCharArray();
            int n = days.length;
            int a = 0;
            int ans = 0;

            for (int s = 0, e = 0; e < n; e++){
                if(days[e] == '0'){
                    a++;
                }

                while(a > 1){
                    if(days[s] == '0'){
                        a--;
                    }
                    s++;
                }

                ans = Math.max(ans, e -  s + 1);
            }
            System.out.println(ans);
        }
        out.flush();
    }
}
