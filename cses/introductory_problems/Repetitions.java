package cses.introductory_problems;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] p = in.nextLine().toCharArray();

        int len = 1;
        int s, e;
        for (s = 0, e = 0; e < p.length; e++){
            if(p[s] == p[e]){
                continue;
            }else{
                len = Math.max(len, e - s);
                s = e;
            }
        }

        len = Math.max(len, e - s);

        System.out.println(len);
    }
}
