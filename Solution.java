import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            queue.add(new int[]{i, 0});
            p[i][0] = true;
        }

        for (int j = 1; j < n; j++){
            queue.add(new int[]{0, j});
            p[0][j] = true;
        }

        int[] dir = {0,1,0,-1,0};
        while(!queue.isEmpty()){
            int[] cor = queue.remove();
            for (int i = 0; i < 4; i++){
                int nr = cor[0] + dir[i];
                int nc = cor[1] + dir[i + 1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !p[nr][nc] && matrix[cor[0]][cor[1]] <= matrix[nr][nc]){
                    queue.add(new int[]{nr, nc});
                    p[nr][nc] = true;
                }
            }
        }


        queue.clear();
        for (int i = 0; i < m; i++){
            queue.add(new int[]{i, n - 1});
            a[i][n - 1] = true;
        }

        for (int j = 0; j < n - 1; j++){
            queue.add(new int[]{m - 1, j});
            a[m - 1][j] = true;
        }

        while(!queue.isEmpty()){
            int[] cor = queue.remove();
            for (int i = 0; i < 4; i++){
                int nr = cor[0] + dir[i];
                int nc = cor[1] + dir[i + 1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !a[nr][nc] && matrix[cor[0]][cor[1]] <= matrix[nr][nc]){
                    queue.add(new int[]{nr, nc});
                    a[nr][nc] = true;
                }
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(a[i][j] && p[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}