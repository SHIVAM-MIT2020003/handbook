package platforms.interview_bit.smallest_multiple_with_0_1;

/*
You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.

Note:

Returned string should not contain leading zeroes.
For example,
 */
import java.util.*;

public class Solution {
    public String multiple(int A) {
        if(A == 0) return "0";
        Queue<StringBuilder> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new StringBuilder("1"));
        while(!queue.isEmpty()){
            StringBuilder num = queue.remove();
            int rem = check(num, A);
            if(rem == 0) return num.toString();

            if(!set.contains(rem)){
                queue.add(new StringBuilder(num).append('0'));
                queue.add(num.append('1'));
                set.add(rem);
            }
        }
        return "";
    }

    public int check(StringBuilder num, int A){
        int c = 0;
        for (int i = 0; i < num.length(); i++){
            c = c * 10 + (num.charAt(i) - '0');
            c = c % A;
        }
        return c;
    }
}
