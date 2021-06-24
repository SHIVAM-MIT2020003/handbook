package cheatsheet;


import java.util.*;

public class Trees {
    int N;
    int[] st;

    public void update(int i, int v) {
        i += N;
        st[i] += v - st[i]; //remember this
        for (i /= 2; i >= 1; i /= 2){
            st[i] = st[i * 2] + st[2 * i + 1];
        }
    }

    public int sumRange(int a, int b) {
        a += N; b += N;
        int sum = 0;
        while(a <= b){
            if(a % 2 == 1) sum += st[a++];
            if(b % 2 == 0) sum += st[b--];
            a /= 2; b/= 2;
        }
        return sum;
    }

    /*
   pattern
   e ----L----|-----R-------
   L <= e and R > e
   recursively for left and right too
    */

    public int preOrderValidation(ArrayList<Integer> A) {
        Stack<Integer> s=new Stack<>();
        int root= Integer.MIN_VALUE; // left all done check in right only

        for(Integer a : A){
            if(a < root)
                return 0;
            while(!s.isEmpty() && s.peek() < a){
                root=s.pop();
            }
            s.push(a);
        }
        return 1;
    }
}
