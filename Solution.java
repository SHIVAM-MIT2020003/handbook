
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,4,3,2,1};
        new Solution().candy(nums);
    }
    public int candy(int[] rating) {
        int n = rating.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++){
            if(rating[i - 1] < rating[i]){
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--){
            if(rating[i] > rating[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }

        Arrays.stream(rating).forEach(val -> System.out.print(val + " "));
        System.out.println();
        Arrays.stream(left).forEach(val -> System.out.print(val + " "));
        System.out.println();
        Arrays.stream(right).forEach(val -> System.out.print(val + " "));
        System.out.println();

        int ans = 0;
        for (int i = 0; i < n; i++){
            ans += Math.max(left[i], right[i]);
        }

        return ans;
    }
}