package FindTheDuplicateNumber;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */


//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)
// 数组中的每个数的值都在1到n之间，并且整个数组的长度为n+1


//leetcode 上面的高赞解答，类似于链表循环上2，也是双指针解题法，一个快指针，一个慢指针。
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        if (len == 0) return -1;
        int slow = nums[0];      //定义一个慢指针
        int fast = nums[nums[0]]; //定义一个快指针，此处需要注意
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
    }
}
