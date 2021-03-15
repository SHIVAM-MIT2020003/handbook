package interview_bit.second_number;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve(1, 10, 1, 1 ));
    }
    public int solve(int A, int B, int C, int D) {
        int L = C;
        int R = B - A;
        L = L % D == 0 ? L : ((L + D) / D) * D;
        R = (R / D) * D;
        System.out.println(L + " " + R);
        int ans = ((R - L) / D) + 1;
        return ans;
    }
}

