package ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int result = 0;
        if (nums.length <= 1) {
            return 0;
        }
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (newNums[i] != nums[i]) {
                flag = false;
            }
        }
        if (flag) {
            return nums.length;
        }
        int head = 0;
        int tail = nums.length - 1;
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] != nums[i]) {
                head = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (newNums[i] != nums[i]) {
                tail = i;
                break;
            }
        }
        result = tail - head + 1;
        return result;
    }
}
