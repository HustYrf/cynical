package KthLargestElementInAnArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargestElementInAnArray {
    /** Hash思想 */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        int[] arr = new int[max - min + 1];
        for (int n : nums) arr[max - n]++;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= k) {
                return max - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray k = new KthLargestElementInAnArray();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(k.findKthLargest(nums, 2));
    }
}


//class Solution {
//    /** Hash思想 */
//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
//        int max = nums[0], min = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max) max = nums[i];
//            if (nums[i] < min) min = nums[i];
//        }
//        int[] arr = new int[max - min + 1];
//        for (int n : nums) arr[max - n]++;
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            if (sum >= k) {
//                return max - i;
//            }
//        }
//        return 0;
//    }
//}
