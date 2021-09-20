
import java.util.*;

interface A{}
interface B extends A{}

public class Solution2 {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        boolean[] isPrime = sieveOfEratosthenes(100000);
        int[] freqA = solve(A, isPrime);
        int[] freqB = solve(B, isPrime);

        long ans = B;

        int t = 0;
        for (int i = 2; i <= A; i++){
            if(isPrime[i]){
//                t = ??;//inclusion exclusion
//                ans += ((freqA[i] - freqA[t]) * (B - (i <= B ? freqB[i] : 0)));
            }
        }


        System.out.println(ans);
    }



    public static int[] solve(int A, boolean[] prime){
        int[] freq = new int[A + 1];
        for (int i = 2; i <= A; i++){
            if(prime[i]){
                freq[i] = A / i;
            }
        }
        return freq;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans, true);
        ans[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (ans[i]) {
                for (int j = i + i; j <= n; j = j + i) {
                    ans[j] = false;
                }
            }
        }
        return ans;
    }
}
