package MoveZeroes;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length < 0) return;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                if (i == 0) {
                    continue;
                } else {
                    len = i - 1;
                    while (len >= 0) {
                        if (nums[len] == 0) {
                            len--;
                        }else{
                            break;
                        }
                    }
                    swap(nums, i, len + 1);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
