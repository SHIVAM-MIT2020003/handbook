
import java.util.*;
public class Solution {
    public static void main(String[] args) {
    }

    public int maxSpecialProduct(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        int[] R = new int[n];
        R[n - 1] = -1;
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--){
            while(!stack.isEmpty() && A[i] >= A[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                R[i] =  -1;
            }else{
                R[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] L = new int[n];
        L[0] = -1;
        stack.clear();
        System.out.println(stack.size());

        stack.push(0);
        for (int i = 1; i < n; i++){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                L[i] = -1;
            }else{
                L[i] = stack.peek();
            }
            stack.push(i);
        }
        Arrays.stream(L).forEach(val -> System.out.print(val + " "));
        System.out.println();
        Arrays.stream(R).forEach(val -> System.out.print(val + " "));
        System.out.println();
        int ans = 0;
        for (int i = 1; i < n - 1; i++){
            if(L[i] > 0 && R[i] > 0){
                ans = Math.max(ans, L[i] * R[i]);
            }
        }
        return ans;
    }
}
