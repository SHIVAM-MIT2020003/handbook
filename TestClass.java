import java.util.*;
import java.io.*;


class TestClass {
    public static void main(String[] args) {
        IScanner in = new IScanner();
        int n = in.nextInt();
        System.out.println(new TestClass().getCount(n));
    }

    public int getCount(int n) {
        // Code here
        long max = n / 2;
        int count = 0;

        for (long r = max; r * (r + 1) / 2 >= n ; r--){
            long sum = (r * (r + 1)) / 2;
            if(sum == n){
                count++;
            }else if(find(sum, n)){
                count++;
            }
        }

        return count;
    }

    public boolean find(long sum, int n){
        long left = 0, right = n;
        while(left <= right){
            long mid = (left + right) / 2;
            long temp = sum - (mid * (mid + 1) / 2);
            if(temp == n) return true;
            else if (temp > n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }


    public long bs(long n){
        long left = 0l, right = (long)n;
        long tar = 2l * n;
        long res = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            if(mid * (mid + 1) >= tar){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
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
