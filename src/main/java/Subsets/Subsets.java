package Subsets;

import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 */
//[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        dfs(result, 0, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, int start, List<Integer> cur, int[] nums) {
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(Integer.valueOf(nums[i]));
            dfs(result, i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        obj.subsets(nums);
    }
}
