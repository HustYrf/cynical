package NextPermutation;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int len = nums.length;
        int index = 0;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i; //找出第一个后者值比前者值大的元素
                break;
            }
        }
        if (index == 0) { //整个nums数组就是一个从大到小的数组
            reverseArrs(nums, 0, len - 1);
            return;
        }
        int value = nums[index - 1];
        int j = len - 1;
        for (; j > index; j--) {   //从index位置的元素中找出一个index位置元素之前的值小的元素
            if (nums[j] > value) {
                break;
            }
        }
        swap(nums, j, index - 1);
        reverseArrs(nums,index,len-1);
        return;
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

}
