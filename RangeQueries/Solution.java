package RangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        IScanner in = new IScanner();
        int N = in.nextInt();
        int Q = in.nextInt();
        StringBuilder str = new StringBuilder(in.nextLine());
        int[][] mat = init(str.toString());
        while(Q-- > 0) {
            if (in.nextInt() == 1) {
                int idx = in.nextInt();
                char ch = in.next().charAt(0);
                int r = ch - 'a';
                update(r, idx, 1, N, mat);
                update(str.charAt(idx - 1) - 'a', idx, -1, N, mat);
                str.setCharAt(idx - 1, ch);
            } else {
                int L = in.nextInt();
                int R = in.nextInt();
                solve(L, R, mat);
            }
        }
    }

    static void solve(int L, int R, int[][] mat){
        int odds = 0;
        for (int i = 0; i < 26; i++){
            int temp = (get(R, mat, i) - get(L - 1, mat, i));
            System.out.println(temp);
            if(temp % 2 == 1){
                odds++;
            }
        }
        if(odds <= 1){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }

    static int[][] init(String str){
        int[][] mat = new int[26][str.length() + 1];
        for (int i = 0; i < str.length(); i++){
            mat[str.charAt(i) - 'a'][i + 1] = 1;
        }

        return calBIT(mat);
    }

    static int[][] calBIT(int[][] mat){
        int n = mat[0].length;
        int[][] nmat = new int[26][n];
        for (int i = 0; i < 26; i++){
            for(int j = 1; j < n; j++){
                if(mat[i][j] != 0)
                    update(i, j, mat[i][j], n, nmat);
            }
        }
        return nmat;
    }

    static void update(int i, int j, int val, int n, int[][] mat){
        while(j < n){
            mat[i][j] += val;
            j = j + (j & (-j));
        }
    }

    static int get(int e, int[][] mat, int i){
        int sum = 0;
        while(e > 0){
            sum += mat[i][e];
            e = e - (e & (-e));
        }
        return sum;
    }
}

class IScanner {
    BufferedReader br;
    StringTokenizer st;
    public IScanner()
    {
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

    String nextLine(){
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}



