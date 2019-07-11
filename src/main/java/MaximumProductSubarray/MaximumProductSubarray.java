package MaximumProductSubarray;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
//[-2,3,-4]
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int result = nums[0];
        int max = nums[0];  //之前最大值
        int min = nums[0];   //之前最小值
        int maxTemp, minTemp;
        for (int i = 1; i < nums.length; i++) {
            maxTemp = max * nums[i];
            minTemp = min * nums[i];

            max = Math.max(Math.max(maxTemp, minTemp), nums[i]);
            min = Math.min(Math.min(maxTemp, minTemp), nums[i]);

            if (max > result) {
                result = max;
            }

        }
        return result;
    }

    //[2,-5,-2,-4,3]
    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums = new int[]{-2, 0, -1};
        System.out.println(maximumProductSubarray.maxProduct(nums));
    }
}
