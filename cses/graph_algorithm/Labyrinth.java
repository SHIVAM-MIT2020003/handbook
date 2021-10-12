package cses.graph_algorithm;

import java.io.*;
import java.util.*;


/*
    find minimum length path from A to B
 */

public class Labyrinth {
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

    public static void main(String[] args) {
        int m = in.nextInt();
        int n = in.nextInt();

        char[][] grid = new char[m][];

        for (int i = 0; i < m; i++){
            grid[i]  = in.nextLine().toCharArray();
        }

        Queue<Info> queue = new LinkedList<>();
        boolean[][] iv = new boolean[m][n];

        int[] src = new int[2];
        int[] dest = new int[2];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 'A'){
                    src = new int[]{i, j};
                }else if(grid[i][j] == 'B'){
                    dest = new int[]{i, j};
                }
            }
        }

        queue.offer(new Info(src[0], src[1]));
        iv[src[0]][src[1]] = true;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        int[][] table = new int[m][n];
        // U:  1, R: 2, D: 3, L: 4

        boolean isFound = false;
        while(!queue.isEmpty() && !isFound){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int r = queue.peek().r;
                int c = queue.peek().c;
                queue.remove();
                if(grid[r][c] == 'B'){
                    isFound = true;
                }

                for (int d = 0; d < 4; d++){
                    int nr = r + row[d];
                    int nc = c + col[d];

                    if(nr  >= 0 && nr < m && nc >= 0 && nc < n && (grid[nr][nc] != '#') && !iv[nr][nc]){
                        queue.offer(new Info(nr, nc));
                        iv[nr][nc] = true;
                        table[nr][nc] = d + 1;
                    }
                }
            }
        }

        if(!isFound)
            out.println("NO");
        else{
            StringBuilder path = new StringBuilder("");
            int i = dest[0], j = dest[1];

            while(grid[i][j] != 'A'){
                if(table[i][j] == 1){
                    path.append("U");
                    i++;
                }else if(table[i][j] == 2){
                    path.append("R");
                    j--;
                }else if(table[i][j] == 3){
                    path.append("D");
                    i--;
                }else if(table[i][j] == 4){
                    path.append("L");
                    j++;
                }
            }

            out.println("YES");
            out.println(path.length());
            out.println(path.reverse().toString());

        }
        out.flush();
    }

    static class Info{
        int r, c;
        public Info(int i, int j){
            r = i;
            c = j;
        }
    }
}

