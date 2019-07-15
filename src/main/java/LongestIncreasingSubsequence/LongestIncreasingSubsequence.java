package LongestIncreasingSubsequence;


/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
//[10,9,2,5,3,4]
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int[] dp = new int[len];
        dp[len - 1] = 1;
        int max;
        for (int j = len - 2; j >= 0; j--) {
            max = 1;
            for (int i = j + 1; i < len; i++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[i] + 1);
                }
            }
            dp[j] = max;
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
