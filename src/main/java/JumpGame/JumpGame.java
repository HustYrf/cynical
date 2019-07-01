package JumpGame;

//Input: [2,3,1,1,4]
//        Output: true
//        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
public class JumpGame {
    public boolean canJump(int[] nums) {         //贪心算法
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }


    /**
     * TLE
     */
//    public boolean canJump(int[] nums) {
//        return recursive(0, nums);
//    }
//    public boolean recursive(int position, int[] nums) {
//        if (position == nums.length - 1) {
//            return true;
//        }
//
//        int furthestJump = Math.min(position + nums[position], nums.length - 1);
//        for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
//            if (recursive(nextPosition, nums)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums = new int[]{2, 0, 1, 0, 4};
        System.out.println(jumpGame.canJump(nums));
    }
}
