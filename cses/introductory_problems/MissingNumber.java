package cses.introductory_problems;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();
        long sum = N * (N + 1) / 2;
        for (int i = 0; i < N - 1; i++){
            sum -= in.nextLong();
        }
        System.out.println(sum);
    }
}
