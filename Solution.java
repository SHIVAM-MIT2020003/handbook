import java.util.*;
class Solution {
    public static void main(String[] args) {
        int[][] grid =  {
        {1,1,0,1,1},
        {1,1,1,1,1},
        {1,1,0,1,1},
        {1,1,0,1,1}};

        System.out.println(new Solution().minDays(grid));
    }
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] iv = new boolean[m][n];
        int[][] start = new int[m][n];
        int[][] low = new int[m][n];
        int cc = 0;
        boolean ap = false;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                    if(!iv[i][j]){
                        cc++;
                        if(dfs(grid, i, j, -1, -1, iv, start, low, 0)){
                            ap = true;
                        }
                    }
                }

            }
        }

        if(cc >= 2 || count == 0) return 0;
        if(ap || count == 1) return 1;
        if(count > 1) return 2;
        return -1;

    }


    int[] dirr = {-1, 1, 0, 0};
    int[] dirc = {0, 0, -1, 1};


    public boolean dfs(int[][] grid, int r, int c, int pr, int pc, boolean[][] iv,
                       int[][] start, int[][] low, int time){
        time++;
        start[r][c] = time;
        low[r][c] = time;
        iv[r][c] = true;
        int count = 0;
        boolean res = false;

        for (int i = 0; i < 4; i++){
            int nr = r + dirr[i];
            int nc = c + dirc[i];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                if(!iv[nr][nc]){
                    count++;
                    res = res || dfs(grid, nr, nc, r, c, iv, start, low, time);
                    low[r][c] = Math.min(low[r][c], low[nr][nc]);

                    if(pr == -1 && count > 1){
                        res = true;
                    }
                    if(pr != -1 && (start[r][c] <= low[nr][nc])){
                        res = true;
                    }

                }else if((pr != -1) && (nr != pr || nc != pc)){
                    low[r][c] = Math.min(low[r][c], low[nr][nc]);
                }
            }
        }
        return res;
    }
}