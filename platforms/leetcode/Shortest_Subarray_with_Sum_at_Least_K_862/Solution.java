package platforms.leetcode.Shortest_Subarray_with_Sum_at_Least_K_862;

import java.util.*;

class Solution {
    public int minSubArrayLen(int target, int[] A) {
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++){
            sum += A[i];
            while(!dq.isEmpty() && sum - dq.getFirst() >= target){
                dq.removeFirst();
            }

            if(sum >= target){
                ans =  Math.min(ans, dq.size());
            }
        }
        return ans;
    }
}