package placement2021.razorpay;

    import java.util.*;

    public class Ques3 {
        public static int solve(int[][] A){
            //A[i][0] : start time, A[i][1] : end time, A[i][2] : profit;

            Arrays.sort(A, (a, b) -> Integer.compare(a[1], b[1])); // sort with respect to end time;
            int n = A.length;
            int[] prefixMax = new int[n];
            prefixMax[0] = A[0][2];

            for (int i = 1; i < n; i++){
                prefixMax[i] = Math.max(prefixMax[i - 1], A[i][2]);
            }

            int max = 0;
            for (int i = 1; i < n; i++){
                int left = 0, right = i - 1;
                int desiredLoc = -1;
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(A[mid][1] < A[i][0]){
                        desiredLoc = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }

                if(desiredLoc != -1){
                    max = Math.max(max, A[i][2] + prefixMax[desiredLoc]);
                }
            }

            return max;
        }
    }
