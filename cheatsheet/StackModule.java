package cheatsheet;


import java.util.Stack;

public class StackModule {
    public int longestValidParentheses(String s) {
        char[] bk = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int ans = 0, i = 0, cost = 0;
        while(i < s.length()){
            if(bk[i] == '('){
                stack.push(cost);
                stack.push(i);
                cost = 0;
            }else{
                if(stack.isEmpty()){
                    cost = 0;
                }else{
                    int val = i - stack.pop() + 1 + stack.pop();
                    ans = Math.max(val, ans);
                    cost = val;
                }
            }
            i++;
        }
        return ans;
    }
}
