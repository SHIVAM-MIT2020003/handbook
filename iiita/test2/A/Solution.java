package iiita.test2.A;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] price = new long[n];
        for (int i = 0; i < n; i++){
            price[i] = in.nextLong();
        }

        TreeSet<Long> ts = new TreeSet<>();
        ts.add(price[n - 1]);
        long loss = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--){
            Long val = ts.floor(price[i]);
            if(val != null && val <= price[i])
                loss = Math.min(loss, price[i] - val);
            ts.add(price[i]);
        }
        System.out.println(loss);
    }
}
