
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        String s = "ILoveIBM";
        List<String> words = new ArrayList<>();
        words.add("I");
        words.add("YOU");
        words.add("IBM");
        words.add("Love");
        words.add("We");

        System.out.println(checkString(s, words));
    }

    public static boolean checkString(String s, List<String> words){
        int n = s.length();
        Set<String> set = new HashSet<>(words);
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--){
            for (int j = i; j < n; j++){
                dp[i] = dp[i] || (set.contains(s.substring(i, j + 1)) && dp[j + 1]);
            }
        }

        return dp[0];
    }
}