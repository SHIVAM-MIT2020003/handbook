package cses.introductory_problems;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextLong();
        }

        long ans = 0l;
        for (int i = 1; i < n; i++){
            if(nums[i] >= nums[i - 1]){
                continue;
            }else{
                ans += nums[i - 1] - nums[i];
                nums[i] = nums[i - 1];
            }
        }

        System.out.println(ans);
    }
}


