package SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {//mid右边是有序的
                if (target > nums[mid] && target <= nums[right]) {  //target在mid--right之间
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {//mid左边是有序的
                if (target < nums[mid] && target >= nums[left]) { //target在left--mid之间
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int[] nums = new int[]{1, 3, 5};
        System.out.println(obj.search(nums, 3));
    }
}
