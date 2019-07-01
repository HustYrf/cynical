package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        recursiveAndBacktrace(candidates, result, list, target, target, 0);
        return result;
    }

    private void recursiveAndBacktrace(int[] nums, List<List<Integer>> result, List<Integer> list, int target, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(list));  //new 一个list 装入
        } else {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);//list装一下数据
                recursiveAndBacktrace(nums, result, list, target, remain - nums[i], i);
                list.remove(list.size() - 1);//回退一个数据
            }
        }
    }
}
