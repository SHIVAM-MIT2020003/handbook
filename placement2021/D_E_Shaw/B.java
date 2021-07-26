package placement2021.D_E_Shaw;

import java.util.*;

public class B {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(solve(nums));
    }
    static int power(int x, int y, int p)
    {
        int res = 1;
        x = x % p;
        if (x == 0)
            return 0;
        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % p;
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    public static double solve(int[] nums){
        int mod = (int)(1e9+7);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int n = nums.length;
        double denomi = power(2, n, mod);
        double numer = 0.0;
        double res = 0.0;
        for(int key : freq.keySet()){
            numer  = power(2, freq.get(key) - 1, mod);
            res += (numer / denomi);
        }
        return res;
    }
}
