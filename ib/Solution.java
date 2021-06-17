package ib;
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = 0;
        for (int val : nums){
            target += val;
        }
        if(target % k != 0) return false;

        return dfs(nums, target / k, 0, k, 0,new boolean[(1 << 16) + 5]);
    }

    public boolean dfs(int[] A, int target, int cur, int setcount, int isUsed, boolean[] memo){
        if(cur > target || memo[isUsed]) return false;
        if(setcount == 0) return true;
        if(cur == target && dfs(A, target, 0, setcount - 1, isUsed, memo))
            return true;
        for (int i = 0; i < A.length; i++)
        {
            if((isUsed & (1 << i)) == 0){
                if(dfs(A, target, cur + A[i], setcount, isUsed | (1 << i), memo)){
                    return true;
                }
            }
        }
        memo[isUsed] = true;
        return false;
    }
}