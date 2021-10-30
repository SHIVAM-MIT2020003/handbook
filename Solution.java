
import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    public static void main(String[] args) {

        IScanner in = new IScanner();
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        System.out.println(solve(s, n));


    }

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

    static int solve(String A, int n){
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            int ascii = A.charAt(i) - 'A' + 1;
            nums[i] = ascii;
        }

        TreeSet<Integer> odd = new TreeSet<>((a, b) -> Integer.compare(nums[a], nums[b]));
        TreeSet<Integer> even = new TreeSet<>((a, b) -> Integer.compare(nums[a], nums[b]));

        for (int i = 0; i < n; i++)
        {
            if(nums[i] % 2 == 0){
                even.add(i);
            }else{
                odd.add(i);
            }
        }
        for (int i = 0; i < n; i++){
            odd.remove(i);
            even.remove(i);

            if(nums[i] % 2 == 0){
                if(odd.isEmpty()){
                    continue;
                }else{
                    int temp = odd.pollFirst();
                    if(nums[i] > nums[temp]){
                        int t = nums[i];
                        nums[i] = nums[temp];
                        nums[temp] = t;
                        even.add(temp);
                    }else {
                        odd.add(temp);
                    }
                }
            }else{
                if(even.isEmpty()) continue;
                else{
                    int tempi = even.pollFirst();
                    if(nums[i] > nums[tempi]){
                        int t = nums[i];
                        nums[i] = nums[tempi];
                        nums[tempi] = t;
                        odd.add(tempi);
                    }else{
                        even.add(tempi);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            res += i * nums[i];
        }

        return res;
    }
}