package dynamic_programming.count_submatrix;

import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] M, int tar) {
        int m = M.length, n = M[0].length;
        for(int i = 0; i < m; i++){
            for (int j = 1; j < n; j++){
                M[i][j] = M[i][j - 1] + M[i][j];
            }
        }

        int count = 0;
        for (int c1 = 0; c1 < n; c1++){
            for (int c2 = c1; c2 < n; c2++){
                int sum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int r = 0; r < m; r++){
                    sum = sum + M[r][c2] - (c1 - 1 >= 0 ? M[r][c1 - 1] : 0);
                    count += map.getOrDefault(sum - tar, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}