package NumberTheory.Primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(factors(84));
    }
    //O(sqrt(n))
    static boolean prime(int n) {
        if (n < 2) return false;
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) return false;
        }
        return true;
    }

    //close to O(sqrt(n))
    //prime factorization
    static List<Integer> factors(int n){
        List<Integer> ans = new ArrayList<>();
        // If there is factor then it must be less than equal to sqrt(n)
        for (int x = 2; x * x <= n; x++){
            while(n % x == 0){
                ans.add(x);
                n = n / x;
            }
        }
        //if n becomes prime after some factorization then will be no factor other than self
        if(n > 1) ans.add(n);
        return ans;
    }

    //Sieve of Eratosthenes
    //O(n(loglogn)) close to O(n)
    static boolean[] sieveOfEratosthenes(int n){
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans, true);
        ans[1] = false;
        for (int i = 2; i * i <= n; i++){
            if(ans[i]){
                for (int j = 2 * i; j <= n; j += i){
                    ans[j] = false;
                }
            }
        }
        return ans;
    }


    //find all factors
    static List<Integer> allFactors(int n){
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= n; i++){
            if(n % i == 0){
                ans.add(i);
                if(n / i != i){
                    ans.add(n /  i);
                }
            }
        }
        return ans;
    }

    //gcd
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    //Modular exponentiation x^n % m
    long modPow(int x, int n, int m) {
        if (n == 0) return 1 % m;
        long u = modPow(x,n/2,m);
        u = (u * u) % m;
        if (n % 2 == 1) u = (u * x) % m;
        return u;
    }
}
