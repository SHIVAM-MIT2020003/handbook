package platforms.interview_bit.binary_search.allocate_books;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().books(new int[]{ 73, 58, 30, 72, 44, 78, 23, 9 }, 5));
    }
    public int books(int[] A, int B) {
        int n = A.length;
        if(n < B) return -1;
        int L = -1, R = 0;
        for (int i = 0; i < n; i++){
            L = Math.max(L, A[i]);
            R = R + A[i];
        }

        int ans = 0;
        while(L <= R){
            int M = L + (R - L) / 2;
            int c = 0, pages = 0;

            System.out.println(M);
            for (int i = 0; i < n; i++){
                if(pages + A[i] > M){
                    c++;
                    pages = 0;
                }
                pages += A[i];
            }

            if(pages > 0) c++;
            if(c > B){
                L = M + 1;
            }else{
                ans = M;
                R = M - 1;
            }
        }
        return ans;
    }
}
