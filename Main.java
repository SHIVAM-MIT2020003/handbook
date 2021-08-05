
import java.util.*;

class Main {

    public static void main(String[] args) {
        ArrayList<Integer> rolls = new ArrayList<>(Arrays.asList(2,1,2,1,3,4));
        System.out.println(new Main().getWays(2, rolls));
    }

    public int getWays(int n, ArrayList<Integer> maxRolls) {

        long[][] dp = new long[6][n];

        int mod = (int)(1e9+7);

        for (int i = 0; i < 6; i++){
            dp[i][0] = 1l;
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j < 6; j++){
                if(maxRolls.get(j) >= i + 1){
                    dp[j][i]++;
                }
                for (int c = 1; c <= maxRolls.get(j) && (i - c) >= 0; c++){
                    for (int k = 0; k < 6; k++){
                        if(k == j) continue;
                        dp[j][i] = (dp[j][i] + dp[k][i - c]) % mod;
                    }
                }
            }
        }

        long res = 0l;
        for (int i = 0; i < 6; i++){
            res = (res + dp[i][n - 1]) % mod;
        }

        return (int)res;
    }
}
