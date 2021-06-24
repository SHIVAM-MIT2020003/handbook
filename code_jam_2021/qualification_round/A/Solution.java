package code_jam_2021.qualification_round.A;


import java.awt.image.PixelInterleavedSampleModel;
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
        int t = in.nextInt();
        int tc = 0;
        while(t-- > 0){
            tc++;
            int N = in.nextInt();
            int[] nums = new int[N];
            int[] snums = new int[N];
            for (int i = 0; i < N; i++){
                nums[i] = in.nextInt();
                snums[i] = nums[i];
            }
            Arrays.sort(snums);

            int count = 0;
            for (int i = 0; i < N - 1; i++){
                for (int j = i; j < N; j++){
                    if(nums[j] == snums[i]){
                        reverse(nums, i, j);
                        count += (j - i + 1);
                    }
                }
            }
            System.out.println("Case #" + tc + ": " + count);
        }
    }

    public static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}