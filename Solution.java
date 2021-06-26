import java.util.*;

public class Solution {
    public int[][] subsets(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> ans = helper(A);

        Collections.sort(ans, (a, b) -> {

            int min = Math.min(a.size(), b.size());
            for (int i = 0; i < min; i++){
                if(a.get(i) != b.get(i)){
                    if(a.get(i) < b.get(i)) return -1;
                    else return 1;
                }
            }

            return a.size() <= b.size() ? -1 : 1;
        });





        int[][] res = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i).stream().mapToInt(a -> a).toArray();
        }
        return res;
    }

    public List<List<Integer>> helper(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, nums.length, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int i, int n, List<List<Integer>> ans, List<Integer> cur){
        if(i == n){
            ans.add(new ArrayList<>(cur));
            return;
        }

        dfs(nums, i + 1, n, ans, cur);
        cur.add(nums[i]);
        dfs(nums, i + 1, n, ans, cur);
        cur.remove(cur.size() - 1);
    }
}
