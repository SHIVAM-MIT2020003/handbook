package debugging;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
}

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        map.put(0, -1);
        int total = 0;
        for (int i = 0; i < arr.length; i++){
            total += arr[i];
            if(map.containsKey(total - target)){
                list.add(new int[]{map.get(total - target) + 1, i});
            }
            map.put(total, i);
        }

        Collections.sort(list, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++){
            int[] f = list.get(i);
            int len = f[1] - f[0];
            for (int j = i + 1; j < list.size(); j++){
                int[] s = list.get(j);
                if(s[1] < f[0]  || s[0] > f[1]){
                    len += (s[1] - s[0]);
                    if(ans > len){
                        ans = len;
                    }
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}