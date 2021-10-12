package cses.graph_algorithm;

import java.io.*;
import java.util.*;

/*
count components
 */

public class CountingRooms {
    static class IScanner {
        BufferedReader br;
        StringTokenizer st;

        public IScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static IScanner in = new IScanner();
    static PrintWriter out = new PrintWriter(System.out);


    //dfs Solution

    public static void main(String[] args) {
        solveUF();
    }

    static void solveUF(){
        int n = in.nextInt();
        int m = in.nextInt();

        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++){
            grid[i] = in.nextLine().toCharArray();
        }

        int[] leaders = new int[n * m];
        int[] size = new int[n * m];

        Arrays.fill(leaders, -1);
        Arrays.fill(size, 1);

        for  (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] == '.'){
                    leaders[i * m  + j] = i * m + j;
                }
            }
        }

        int[] dir = {0,1,0,-1,0};

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] == '.'){
                    for (int k = 0; k < 4; k++){
                        int ni = i + dir[k];
                        int nj = j + dir[k + 1];

                        if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '.'){
                            union(i * m + j, ni * m + nj, leaders, size);
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < leaders.length; i++){
            if(leaders[i] == i){
                count++;
            }
        }

        out.println(count);
        out.flush();

    }

    static int find(int u, int[] leaders){
        while(u != leaders[u]){
            u = leaders[u];
        }
        return u;
    }

    static void union(int u, int v, int[] leaders, int[] size){
        int pu = find(u, leaders);
        int pv = find(v, leaders);
        if(pu == pv) return;

        if(size[pu] <= size[pv]){
            leaders[pu] = pv;
            size[pv] += size[pu];
        }else{
            leaders[pv] = pu;
            size[pu] += size[pv];
        }
    }


//    DFS solution
    static void solveDFS(){
        int n = in.nextInt();
        int m = in.nextInt();

        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++){
            grid[i] = in.nextLine().toCharArray();
        }


        boolean[][] iv = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(!iv[i][j] &&  grid[i][j] ==  '.'){
                    dfs(grid, i, j, iv);
                    count++;
                }
            }
        }

        out.println(count);
        out.flush();
    }

    static int[] dir = {0,1,0,-1,0};

    public  static void dfs(char[][] grid, int i, int j, boolean[][] iv){
        iv[i][j] = true;
        for (int d = 0; d < 4; d++){
            int ni = i + dir[d];
            int nj = j + dir[d + 1];
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == '.' && !iv[ni][nj]){
                dfs(grid, ni, nj, iv);
            }
        }
    }
}
