package iiita_placement.goldman.ip1;

//keyword problems

import java.util.*;

public class A {
    static String[] nums;
    static class Pair{
        int num;
        String s;
        public Pair(int n, String p){
            num = n;
            s = p;
        }
    }
    public static void main(String[] args) {
        nums = new String[10];
        nums[2] = "abc";
        nums[3] = "def";
        nums[4] = "ghi";
        nums[5] = "jkl";
        nums[6] = "mno";
        nums[7] = "pqrs";
        nums[8] = "tuv";
        nums[9] = "wxyz";
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        List<Pair> ans = new ArrayList<>();
        while(t-- > 0){
            String p = in.nextLine();
            int num = solve(p);
            ans.add(new Pair(num, p));
        }

        Collections.sort(ans, (a, b) -> a.num != b.num ? Integer.compare(b.num, a.num) : a.s.compareTo(b.s));
        for (Pair p : ans){
            System.out.println(p.num + " " + p.s);
        }
    }

    public static int solve(String s){
        StringBuilder ans = new StringBuilder("");
        for (char c : s.toCharArray()){
            outer:
            for (int i = 2; i <= 9; i++){
                for (char ch : nums[i].toCharArray()){
                    if(ch == c){
                        ans.append(i);
                        break outer;
                    }
                }
            }
        }
        return Integer.parseInt(ans.toString());
    }
}
