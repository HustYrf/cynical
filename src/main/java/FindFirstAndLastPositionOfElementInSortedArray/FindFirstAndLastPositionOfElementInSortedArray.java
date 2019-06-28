package FindFirstAndLastPositionOfElementInSortedArray;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        int[] result = new int[]{-1, -1};
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                int first = search(nums, 0, mid - 1, mid, target);
                if (first == -1) {
                    result[0] = 0;
                } else {
                    result[0] = first + 1;
                }
                int second = search(nums, mid + 1, len - 1, mid, target);
                if (second != -1) {
                    result[1] = second - 1;
                } else {
                    result[1] = len - 1;
                }
                return result;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int search(int[] nums, int start, int end, int flag, int target) {
        int midSearch = -1;
        boolean notFind = false;
        while (start <= end) {
            midSearch = (start + end) / 2;
            if (nums[midSearch] != target) {
                if (end < flag) {
                    if (nums[midSearch + 1] == target) {
                        notFind = true;
                        break;
                    } else {
                        start = midSearch + 1;
                    }
                } else {
                    if (nums[midSearch - 1] == target) {
                        notFind = true;
                        break;
                    } else {
                        end = midSearch - 1;
                    }
                }
            } else {
                if (end < flag) {
                    end = midSearch - 1;
                } else {
                    start = midSearch + 1;
                }
            }
        }
        return notFind ? midSearch : -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = new int[]{2, 2};
        int[] result=obj.searchRange(nums, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
