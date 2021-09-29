package placement2021.walmart.ques3;

import java.util.*;
import java.util.Scanner;

//Given an array of numbers [ 1 indexed ] and with an integer K.
//        for ex: A =[ 2 2 2 2 3 2 3 3 3 ] , k = 6
//        Count number of pairs such that :
//        1) A[i] = A[j]
//        2) i<j
//3) ( i*j ) is divisble by k [ product of i & j ]
//        1< k, A[i] < 1e6
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++){
            int val = in.nextInt();
            max = Math.max(max, val);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int count = 0;
        for  (int i : map.keySet()){
            if(k % i == 0){
                if(k / i != i && map.containsKey(k / i)){
                    count += map.get(k /  i);
                }

                int t = k / i;
                for (int j = t * 2; j <= max; j += t){
                    if(map.containsKey(j)){
                        count += map.get(j);
                    }
                }
            }
        }

        System.out.println(count / 2);

    }
}
