package code_jam_2021.qualification_round.C;


import java.util.*;
import java.io.*;

//Programming template
public class Solution {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) return false;
        }
        return true;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans, true);
        ans[1] = false;
        for (int i = 2; i <= n; i++) {
            if (ans[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    ans[j] = false;
                }
            }
        }
        return ans;
    }

    static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++)
            if (((a%m) * (x%m)) % m == 1)
                return x;
        return 1;
    }

    long modPow(int x, int n, int m) {
        if (n == 0) return 1 % m;
        long u = modPow(x, n / 2, m);
        u = (u * u) % m;
        if (n % 2 == 1) u = (u * x) % m;
        return u;
    }

    int max(int ...nums){
        return Arrays.stream(nums).max().getAsInt();
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

    //Main
    public static void main(String[] args) {
        IScanner in = new IScanner();
        int t = in.nextInt(), no = 0;
        while(t-- > 0){
            no++;
            int N = in.nextInt();
            int C = in.nextInt();


            int sum = (N * (N + 1) / 2) - 1;
            if(C > sum || C < N - 1){
                System.out.println("Case #" + no +  ": IMPOSSIBLE");
            }else{
                int[] ans = new int[N + 1];
                int num = 1;
                int isum = C - (N - 1);
                int count = 0;
                int d = N - 1;
                int L = 1, R = N, B = 1;
                boolean rightDir = true;
                while(isum >= 0){
                    count++;
                    if(rightDir){
                        rightDir = false;
                        if(isum == 0){
                            //..........
                            B = L;
                            ans[B] = num++;
                            break;
                        }else if(isum <= d){
                            B = L + isum;
                            ans[B] = num++;
                            break;
                        }else{
                            ans[R--] = num++;
                            isum -= d;
                            d--;
                        }
                    }else{
                        rightDir = true;
                        if(isum == 0){
                            B = R;
                            ans[B] = num++;
                            break;
                        }else if(isum <=  d){
                            B = R - isum;
                            ans[B] = num++;
                            break;
                        }else{
                            ans[L++] = num++;
                            isum -= d;
                            d--;
                        }
                    }
                }

                if(count % 2 == 1){
                    int G = N;
                    while(R > B){
                        ans[R--] = G--;
                    }

                    int i = B - 1;
                    while(i >= L){
                        ans[i--] = num++;
                    }
                }else{
                    int i = L;
                    int large = N;
                    while(i < B){
                        ans[i++] = large--;
                    }
                    i = B + 1;
                    while(i <= R){
                        ans[i++] = num++;
                    }
                }

                System.out.print("Case #" + no +  ": ");
                for (int i = 1; i <= N; i++){
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
        }
    }
}