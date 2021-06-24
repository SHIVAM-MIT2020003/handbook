package maths.gray_code;
import java.util.*;
//1238. Circular Permutation in Binary Representation
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i =  0; i < (1 << n); i++){
            ans.add((i ^ (i >> 1)) ^ start);
        }
        return ans;
    }
}


/*

Ques : How i ^ (i >> 1) work?
Ans :

n = 17
10001
01000
-----
11001 (gray code)


n = 18
10010
01001
-----
11011 (gray code)

 */