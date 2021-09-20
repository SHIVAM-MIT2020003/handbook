package walmart.ques6;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        while(t-- > 0){
            String num = in.nextLine();
            boolean ans = solve(num);
            System.out.println(ans ? "YES" : "NO");
        }
    }

    public static boolean solve(String s){
        for (int i = 0; i < s.length() - 1; i += 2){
            int a = s.charAt(i) - '0';
            int b = s.charAt(i + 1) - '0';
            if(a + b <=  17) return false;
        }
        return true;
    }
}
