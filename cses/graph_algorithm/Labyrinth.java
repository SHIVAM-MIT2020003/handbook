package cses.graph_algorithm;

import java.io.*;
import java.util.*;

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

        outer:
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 'A'){
                    queue.offer(new Info(i, j, ""));
                    iv[i][j] = true;
                    break outer;
                }
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        char[] dir = {'U', 'R', 'D', 'L'};

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int r = queue.peek().r;
                int c = queue.peek().c;
                String path = queue.peek().path;
                queue.remove();
                if(grid[r][c] == 'B'){
                    out.println("YES");
                    out.println(path.length());
                    out.println(path);
                    out.flush();
                    return;
                }

                for (int d = 0; d < 4; d++){
                    int nr = r + row[d];
                    int nc = c + col[d];

                    if(nr  >= 0 && nr < m && nc >= 0 && nc < n && (grid[nr][nc] != '#') && !iv[nr][nc]){
                        queue.offer(new Info(nr, nc, path + dir[d]));
                        iv[nr][nc] = true;
                    }
                }
            }
        }
        out.println("NO");
        out.flush();
    }

    static class Info{
        String path;
        int r, c;
        public Info(int i, int j, String p){
            r = i;
            c = j;
            path = p;
        }
    }
}
