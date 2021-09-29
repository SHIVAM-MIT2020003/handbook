package placement2021.walmart.ques2;

//
//what can be the optimal way?
//Tony is a boss. He has workers working for him. Each worker has a strength.
//While, Tony also has some tasks. Workers will do the task, one worker can do one task only if workers strength is greater than or equal to task requirements.
//There is also a magic pill which will increase the strength of worker by B amount.
//Output the max tasks can be done.
//
//Test Case :
//Number of pill: 2
//B : 1
//
//Workers : [2,4]
//Tasks : [3,2]
//
//Output : 2

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfPills = in.nextInt();
        int B = in.nextInt();
        int n = in.nextInt();
        int[] worker = new int[n];
        int[] tasks = new int[n];

        for (int i = 0; i < n; i++){
            worker[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++){
            tasks[i] = in.nextInt();
        }

        Arrays.sort(worker);
        Arrays.sort(tasks);

        int max = 0;
        int l = 0, r = n - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(isPossible(worker, tasks, m, B, numberOfPills)){
                max = m + 1;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }

        System.out.println(max);
    }

    public static boolean isPossible(int[] workers, int[] tasks, int m, int B, int np){
        int req = 0;
        for (int i = workers.length - 1, j = m; i >= 0 && j >= 0; i--, j--){
            if(tasks[j] > workers[i]){
                req += Math.ceil((tasks[j] - workers[i]) * 1.0 / B);
            }
        }
        return req <= np;
    }
}