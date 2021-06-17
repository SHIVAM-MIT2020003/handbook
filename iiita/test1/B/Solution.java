package iiita.test1.B;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            long f = in.nextLong();
            long s = in.nextLong();
            long tt = in.nextLong();
            long ff = in.nextLong();

            if(f * s >= tt * ff){
                System.out.println(1);
            }else{
                System.out.println(2);
            }
        }
    }
}
