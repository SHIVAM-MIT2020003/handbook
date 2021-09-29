package cses.introductory_problems;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        while(n > 1){
            System.out.print(n + " ");
            if(n % 2  == 0){
                n /= 2;
            }else{
                n = n * 3 + 1;
            }
        }

        System.out.println(1);
    }
}
