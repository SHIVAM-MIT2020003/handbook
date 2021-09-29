
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] weight = new long[n];
        for (int i = 0; i < n; i++){
            weight[i] = in.nextLong();
        }
        long capacity = in.nextLong();
        System.out.println(solve(weight, capacity));
    }

    public static long solve(long[] nums, long capacity) {
        List<Long> first = new ArrayList<>();
        List<Long> second = new ArrayList<>();
        int n = nums.length;
        int mid = n / 2;
        comb(nums, 0, mid, first, 0);
        comb(nums, mid + 1, n - 1, second, 0);
        Collections.sort(second);
        long max = 0l;
        for (long v1 : first){
            long target = capacity - v1;
            long v2 = -1;
            int left = 0, right = second.size() - 1;
            while(left <= right){
                int m = left + (right - left) / 2;
                if(second.get(m) <= target){
                    v2 = second.get(m);
                    left = m + 1;
                }else{
                    right = m - 1;
                }
            }
            if(v2 != -1){
                max = Math.max(v1 + v2, max);
            }
        }
        return max;
    }

    public static void comb(long[] nums, int i, int n, List<Long> list, long sum){
        if(i > n){
            list.add(sum);
            return;
        }
        comb(nums, i + 1, n, list, sum + nums[i]);
        comb(nums, i + 1, n, list, sum);
    }
}
