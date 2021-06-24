package codeforces.global_round_14.C;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();
            int x = in.nextInt();
            int[] ans = new int[N];
            int[] h = new int[N];

            for (int i = 0; i < N; i++) {
                h[i] = in.nextInt();
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
            for (int i = 1; i <= M; i++) {
                pq.add(new Pair(i, 0));
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                Pair cur = pq.poll();
                cur.sum += h[i];
                max = Math.max(max, cur.sum);
                pq.add(cur);
                ans[i] = cur.id;
            }

            if (max - pq.peek().sum > x) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int i = 0; i < N; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
        }
    }

    static class Pair{
        int sum, id;
        public Pair(int i, int s){
            this.sum = s;
            this.id = i;
        }
    }
}
