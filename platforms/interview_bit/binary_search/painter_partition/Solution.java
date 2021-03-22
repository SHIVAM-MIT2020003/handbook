package platforms.interview_bit.binary_search.painter_partition;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().paint(1, 1000000, new int[]{1000000,1000000}));
    }
    public int paint(int A, int B, int[] C) {
        int MOD =  10000003;
        long L = 0, R = 0;
        int n = C.length;
        for (int i = 0; i < n; i++){
            L = Math.max(L, 1l * C[i] * B);
            R += 1l* C[i] * B;
        }

        long ans = 0;
        while(L <= R){
            long M = L + (R - L) / 2;
            int pc = 0;
            long time = 0;
            for (int i = 0; i < n; i++){
                if(time + 1l * C[i] * B > M){
                    pc++;
                    time = 0;
                }
                time += 1l * C[i] * B;
            }

            if(time > 0){
                pc++;
            }

            if(pc > A){
                L = M + 1;
            }else{
                ans = M;
                R = M - 1;
            }
        }
        return (int)(ans % MOD);
    }
}

