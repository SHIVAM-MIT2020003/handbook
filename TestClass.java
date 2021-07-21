import java.util.*;
import java.io.*;


class TestClass {
    static List<Integer>[] arr;
    public static void main(String args[] ) throws Exception {
        IScanner in = new IScanner();
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = in.nextInt();
            }
        }

        sieve(m-1);
        arr = new ArrayList[m];

        for (int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                if(j != i){
                    if(isPrime[Math.abs(i - j)]){
                        arr[i].add(j);
                    }
                }
            }
        }

        System.out.println(maxPoints(grid));

    }

    static boolean[] isPrime;

    public static void sieve(int n){
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++){
            if(isPrime[i]){
                for (int j = 2 * i; j <= n; j = j + i){
                    isPrime[j] = false;
                }
            }
        }
    }

    public static long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++){
            dp[m - 1][j] = points[m - 1][j];
        }


        for (int i = m - 2; i >= 0; i--){
            for (int j = 0; j < n; j++){
                for (int jj : arr[j]) {
                    dp[i][j] = Math.max(dp[i][j], points[i][j] + dp[i + 1][jj]);
                }
            }
        }

        int max = 0;
        for (int j = 0; j < n; j++){
            max = Math.max(max, dp[0][j]);
        }

        return max;

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
