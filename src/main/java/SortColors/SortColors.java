package SortColors;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len<=1) return;
        int zero=0,one=0,two=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]==0){
                zero++;
            }
            if(nums[i]==1){
                one++;
            }
            if(nums[i]==2){
                two++;
            }
        }
        int index = 0;
        for (int i = 0; i < zero; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < one; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < two; i++) {
            nums[index++] = 2;
        }
        return;
    }
}
