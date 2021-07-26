package placement2021.D_E_Shaw;

import java.util.*;

public class C {
    public static void main(String[] args) {
        int[] cost = {11,16,13,12,11,14,16,14,18,12};
        int x = 50;
        System.out.println(new C().largestNumber(cost, x));
    }

    public String largestNumber(int[] cost, int x){
        int firstMin = 0;
        int secondMin = 1;
        //cost length always 10
        for (int i = 1; i < cost.length; i++){
            if(cost[firstMin] >= cost[i]){
                secondMin = firstMin;
                firstMin = i;
            }else if(cost[secondMin] >= cost[i]){
                secondMin = i;
            }
        }

        if(cost[firstMin] > x) return "";
        if(firstMin == 0 && cost[secondMin] > x) return "0";

        int numberOfDigit = 0;
        int[] number;
        if(firstMin == 0){
            numberOfDigit = 1;
            x -= cost[secondMin];
            numberOfDigit += (x / cost[firstMin]);
            x = x % cost[firstMin];
            number = new int[numberOfDigit];
            Arrays.fill(number, 0);
            number[0] = secondMin;
        }else{
            numberOfDigit = x / cost[firstMin];
            x = x % cost[firstMin];
            number  = new int[numberOfDigit];
            Arrays.fill(number, firstMin);
        }

        for (int i = 0; i < numberOfDigit && x > 0; i++){
            for (int j = 9; j >= 1 && j > number[i]; j--){
                if(cost[j] - cost[number[i]] <= x){
                    x -= (cost[j] - cost[number[i]]);
                    number[i] = j;
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < number.length; i++){
            res.append(number[i]);
        }
        return res.toString();
    }
}
