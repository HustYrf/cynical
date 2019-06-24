package ContainerWithMostWater;


/**
 * the function of two pointer
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxContainer = 0, curContainer = 0;
        while (start != end) {
            curContainer = Math.min(height[start], height[end]) * (end - start);
            maxContainer = curContainer>maxContainer?curContainer:maxContainer;
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxContainer;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
