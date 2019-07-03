package Permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTracing(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backTracing(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            backTracing(result, list, nums, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
