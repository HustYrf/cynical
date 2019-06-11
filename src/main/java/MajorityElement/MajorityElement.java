package MajorityElement;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int curValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curValue) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;  //重置
                    curValue = nums[i];
                }
            }
        }
        return curValue;
    }
}
