package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1) return result;
        Arrays.sort(nums);
        result.add(add2List(nums));
        for (; ; ) {
            List<Integer> integers = result.get(result.size() - 1);
            int[] ints = nextPermutation(list2Arr(integers));
            if(result.contains(add2List(ints))) break;
            result.add(add2List(ints));
        }
        return result;
    }

    private int[] nextPermutation(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int j = len - 1; j >= 1; j--) {
            if (nums[j] > nums[j - 1]) {
                index = j;
                break;
            }
        }
        if (index == 0) {
            reverseArrs(nums, 0, len - 1);
            return nums;
        }
        int value = nums[index - 1];
        int k = len - 1;
        for (; k > index; k--) {
            if (nums[k] > value) {
                break;
            }
        }
        swap(nums, k, index - 1);
        reverseArrs(nums, index, len - 1);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseArrs(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private int[] list2Arr(List<Integer> list) {
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    private List<Integer> add2List(int[] nums) {
        List<Integer> single = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            single.add(Integer.valueOf(nums[i]));
        }
        return single;
    }

}

