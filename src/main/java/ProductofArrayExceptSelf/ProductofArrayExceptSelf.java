package ProductofArrayExceptSelf;

/**
 * @ClassName ProductofArrayExceptSelf
 * @Descripition TODO
 * @Author Administrator
 * @Date 2019/7/14 10:59
 **/


//基本思路就是：两个数组，左数组和右数组
//左数组就是当前i位置之前所有数的乘积
//右数组就是当前i之后说有数的乘积
//那么，i位置的结果result[i] = leftArr[i]*right[i]
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] leftArr = new int[len];
        int[] rightArr = new int[len];

        int[] result = new int[len];
        leftArr[0] = 1;

        for (int i = 1; i < len; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i - 1];
        }


        rightArr[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            rightArr[j] = rightArr[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < len; i++) {
            result[i] = leftArr[i] * rightArr[i];
        }
        return result;
    }
}
