package Stack_problems.Psychos_in_a_Line;

import java.io.*;
import java.util.*;

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
        int n = in.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++){
            A[i] = in.nextInt();
        }

        Stack<Integer> mono = new Stack<>();

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        ans[0] = 0;
        mono.push(0);

        for (int i = 1; i < n; i++){
            while(!mono.isEmpty() && A[i] >= A[mono.peek()]){
                ans[i] = Math.max(ans[i], ans[mono.pop()] + 1);
            }
            if(mono.isEmpty()){
                ans[i] = 0;
            }
            mono.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            res = Math.max(ans[i], res);
        }

        out.println(res);
        out.flush();
        out.close();

    }
}
