package ClimbingStairs;

public class ClimbingStairs {
    /*以下方法会有超时问题*/
//    public static int climbStairs(int n) {
//        if( n == 1||n == 2) return n;
//        return climbStairs(n-1)+climbStairs(n-2);
//    }

    //以下采用迭代的方法
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int pre = 1;
        int cur = 2;
        int temp; // 过渡
        for (int i = 3; i <= n; i++) {
            temp = cur;
            cur = cur + pre;
            pre = temp;
        }
        return cur;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

}
